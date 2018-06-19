package com.gxb.sdk.des.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxb.sdk.des.api.DataSourceApi;
import com.gxb.sdk.des.model.dto.ResponseObject;
import com.gxb.sdk.des.model.param.DataRequestParam;
import com.gxb.sdk.des.model.param.HeartbeatReq;
import com.gxchain.common.signature.MsgCryptUtil;
import com.gxchain.common.signature.SignatureUtil;

import java.io.IOException;
import java.util.List;

/**
 * 数据源客户端
 *
 * @author liruobin
 * @since 2018/3/29 下午3:17
 */
public class DatasourceClient extends DESClient {
    DataSourceApi dataSourceApi;
    /**
     * 数据源数据查询地址
     */
    private String queryUrl;

    /**
     *
     * @param privateKey 私钥
     * @param accountId 公链账户id
     * @param queryUrl 查询地址
     */
    public DatasourceClient(String privateKey, String accountId, String queryUrl) {
        super(privateKey, accountId);
        this.queryUrl = queryUrl;
        dataSourceApi = gxbApiFactory.newApi(DataSourceApi.class);
    }

    /**
     *
     * @param privateKey 私钥
     * @param accountId 公链账户id
     * @param queryUrl 查询地址
     * @param baseUrl des服务地址
     */
    public DatasourceClient(String privateKey, String accountId, String queryUrl, String baseUrl) {
        super(privateKey, accountId, baseUrl);
        this.queryUrl = queryUrl;
        dataSourceApi = gxbApiFactory.newApi(DataSourceApi.class);
    }

    /**
     * 心跳检测，需要每30秒发送一次
     *
     * @param products 产品list
     * @throws IOException
     */
    public void heartbeat(List<Integer> products) throws IOException {
        HeartbeatReq heartbeatReq = new HeartbeatReq();
        heartbeatReq.setAccount(this.getAccountId());
        heartbeatReq.setProducts(products);
        heartbeatReq.setQueryUrl(queryUrl);
        heartbeatReq.setTimestamp(System.currentTimeMillis() + 3000L);
        heartbeatReq.setSignature(SignatureUtil.signature(heartbeatReq.toSignatureString(), this.getPrivateKey()));//加密签名
        dataSourceApi.heartBeat(heartbeatReq).execute();
    }

    /**
     * 解密请求参数
     *
     * @param dataRequestParam 请求参数
     * @return 解密结果
     */
    public JSONObject decrypt(DataRequestParam dataRequestParam) {
        //解密
        String paramJson = MsgCryptUtil.decrypt(getPrivateKey(), dataRequestParam.getPublicKey(), dataRequestParam.getNonce(), dataRequestParam.getParams());
        JSONObject jsonObject = JSON.parseObject(paramJson);
        return jsonObject.getJSONObject("params");
    }

    /**
     * 加密数据
     *
     * @param responseObject   结果数据
     * @param dataRequestParam 请求入参
     * @return
     */
    public ResponseObject encrypt(ResponseObject responseObject, DataRequestParam dataRequestParam) {
        if (responseObject == null) {
            return ResponseObject.builder().success(false).build();
        }
        //成功,加密数据;
        if (responseObject.isSuccess() && responseObject.getData() != null) {
            responseObject.setData(MsgCryptUtil.encrypt(getPrivateKey(), dataRequestParam.getPublicKey(), dataRequestParam.getNonce(), JSON.toJSONString(responseObject.getData())));
        } else {
            responseObject.setSuccess(false);
        }
        return responseObject;
    }
}
