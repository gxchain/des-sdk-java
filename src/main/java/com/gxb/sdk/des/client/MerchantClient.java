package com.gxb.sdk.des.client;

import com.alibaba.fastjson.JSONObject;
import com.gxb.sdk.des.api.DataSourceApi;
import com.gxb.sdk.des.api.MerchantApi;
import com.gxb.sdk.des.exception.ExceptionEnum;
import com.gxb.sdk.des.exception.GxbApiException;
import com.gxb.sdk.des.model.dto.AccountInfo;
import com.gxb.sdk.des.model.dto.DataExchangeDetailDto;
import com.gxb.sdk.des.model.dto.DataExchangeDto;
import com.gxb.sdk.des.model.dto.ProductResultDto;
import com.gxb.sdk.des.model.enums.DataExchangeStatusEnum;
import com.gxb.sdk.des.model.param.Amount;
import com.gxb.sdk.des.model.param.DataExchangeReq;
import com.gxb.sdk.des.model.param.RequestParams;
import com.gxb.sdk.des.util.ParamUtil;
import com.gxchain.common.signature.MsgCryptUtil;
import com.gxchain.common.signature.SignatureUtil;
import com.gxchain.common.signature.utils.Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 商户客户端
 *
 * @author liruobin
 * @since 2018/3/29 下午3:17
 */
public class MerchantClient extends DESClient {
    private static final Logger logger = LoggerFactory.getLogger(MerchantClient.class);
    MerchantApi merchantApi;
    DataSourceApi dataSourceApi;

    public MerchantClient(String privateKey, String accountId) {
        super(privateKey, accountId);
        merchantApi = gxbApiFactory.newApi(MerchantApi.class);
        dataSourceApi = gxbApiFactory.newApi(DataSourceApi.class);
    }

    public MerchantClient(String privateKey, String accountId, String baseUrl) {
        super(privateKey, accountId, baseUrl);
        merchantApi = gxbApiFactory.newApi(MerchantApi.class);
        dataSourceApi = gxbApiFactory.newApi(DataSourceApi.class);
    }

    /**
     * 创建数据交易请求
     *
     * @param productId 产品id
     * @param params    数据请求参数
     * @return 数据交易请求id
     * @throws IOException
     * @throws GxbApiException
     */
    public String createDataExchangeRequest(Integer productId, JSONObject params) throws IOException, GxbApiException {
        //查询产品信息
        ProductResultDto productResult = this.getProduct(productId);
        if (productResult.getOnlineDatasources() == null || productResult.getOnlineDatasources().isEmpty()) {
            throw new GxbApiException(ExceptionEnum.DATASOURCE_OFFLINE);
        }
        //校验params的格式是否符合产品的入参
        if (!ParamUtil.checkParamValid(productResult.getProduct().getInput(), params)) {
            throw new GxbApiException(ExceptionEnum.INVALID_PARAMS);
        }
        JSONObject param = new JSONObject();
        param.put("params", params);
        //给请求参数增加时间戳后，再加密
        param.put("timestamp", System.currentTimeMillis());
        //创建交易
        List<DataExchangeReq> dataExchangeReqList = new ArrayList<>();
        logger.debug("开始组织请求参数");
        long expiration = DateTime.now().plusMinutes(30).toDate().getTime() / 1000;
        for (AccountInfo datasourceAccount : productResult.getOnlineDatasources()) {
            if (StringUtils.equals(this.getAccountId(), datasourceAccount.getAccountId())) {
                continue;
            }
            //组织请求参数
            DataExchangeReq req = new DataExchangeReq();
            RequestParams requestParams = new RequestParams();
            requestParams.setFrom(this.getAccountId());
            requestParams.setTo(datasourceAccount.getAccountId());
            requestParams.setProxyAccount(productResult.getDes().getAccountId());
            requestParams.setPercent(productResult.getDes().getPercent());
            //请求参数MD5
            requestParams.setMemo(DigestUtils.md5Hex(param.toJSONString()));
            requestParams.setExpiration(expiration);//设置授权过期时间,1分钟

            Amount amount = new Amount();
            amount.setAmount(productResult.getProduct().getPrice().getAmount());
            amount.setAssetId(productResult.getProduct().getPrice().getAssetId());
            requestParams.setAmount(amount);
            requestParams.setSignatures(Arrays.asList(this.signature(requestParams, this.getPrivateKey())));//request_params结构体签名
            req.setRequestParams(requestParams);

            req.setNonce(RandomUtils.nextLong(0L, Long.MAX_VALUE));

            req.setParams(MsgCryptUtil.encrypt(getPrivateKey(), datasourceAccount.getPublicKey(), req.getNonce(), param.toJSONString()));//加密请求参数
            dataExchangeReqList.add(req);

        }
        if(dataExchangeReqList.isEmpty()){
            throw new GxbApiException(ExceptionEnum.DATASOURCE_OFFLINE);
        }
        //发送创建交易的请求
        logger.info("创建数据交易请求");
        Response<JSONObject> response = merchantApi.dataExchange(productId, dataExchangeReqList).execute();
        logger.info("数据交易请求完成：{}", response.body().getString("request_id"));
        return response.body().getString("request_id");
    }

    /**
     * 签名
     *
     * @param requestParams
     * @param privateKey
     * @return
     */
    private String signature(RequestParams requestParams, String privateKey) {
        logger.debug("准备开始签名");
        String sign = SignatureUtil.signature(requestParams.toBytes(), privateKey);
        byte[] sigData = Util.hexToBytes(sign);
        while (((sigData[1] & 128) != 0 || sigData[1] == 0 || (sigData[2] & 128) != 0 || (sigData[33] & 128) != 0 || sigData[33] == 0 || (sigData[34] & 128) != 0)) {
            requestParams.setExpiration(requestParams.getExpiration() + 1);
            sign = SignatureUtil.signature(requestParams.toBytes(), privateKey);
            sigData = Util.hexToBytes(sign);
        }
        logger.debug("签名完成");
        return sign;
    }

    /**
     * 查询产品信息
     *
     * @param productId 产品id
     * @return
     * @throws IOException
     * @throws GxbApiException
     */
    public ProductResultDto getProduct(Integer productId) throws IOException, GxbApiException {
        if (logger.isDebugEnabled()) {
            logger.debug("查询产品信息:{}", productId);
        }
        Response<ProductResultDto> response = merchantApi.getProduct(productId).execute();
        return response.body();
    }

    /**
     * 查询数据交易结果
     *
     * @param requestId 请求id
     * @return 数据结果
     * @throws IOException
     */
    public DataExchangeDto getResult(String requestId) throws IOException, GxbApiException {
        return this.getResult(requestId, 8);
    }

    /**
     * 查询数据交易结果
     *
     * @param requestId 请求id
     * @param second    超时时间(秒)
     * @return 数据结果
     * @throws IOException
     */
    public DataExchangeDto getResult(String requestId, int second) throws IOException, GxbApiException {
        if (logger.isDebugEnabled()) {
            logger.debug("查询数据交易结果:{}", requestId);
        }
        Long l1 = System.currentTimeMillis();
        //轮询DES服务器
        while (true) {
            DataExchangeDto dataExchange = merchantApi.getExchangeData(requestId).execute().body();
            //反馈的结果不能为空，或者任务状态为执行中
            if (dataExchange != null && DataExchangeStatusEnum.IN_PROGRESS != dataExchange.getStatus()) {
                if (dataExchange.getDatasources() == null || dataExchange.getDatasources().isEmpty()) {
                    return dataExchange;
                }
                for (DataExchangeDetailDto dataExchangeDetail : dataExchange.getDatasources()) {
                    if (!"SUCCESS".equals(dataExchangeDetail.getStatus().name())) {
                        continue;
                    }
                    dataExchangeDetail.setData(MsgCryptUtil.decrypt(getPrivateKey(), dataExchangeDetail.getDatasourcePublicKey(), dataExchangeDetail.getNonce(), dataExchangeDetail.getData()));
                }
                return dataExchange;
            }
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {

            }
            if (System.currentTimeMillis() - l1 > second * 1000) {
                break;
            }
        }
        return null;
    }
}
