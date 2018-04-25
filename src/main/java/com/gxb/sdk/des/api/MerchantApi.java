package com.gxb.sdk.des.api;

import com.alibaba.fastjson.JSONObject;
import com.gxb.sdk.des.model.dto.DataExchangeDto;
import com.gxb.sdk.des.model.dto.ProductResultDto;
import com.gxb.sdk.des.model.param.DataExchangeReq;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * 商户api
 * @author liruobin
 * @since 2018/3/29 上午11:57
 */
public interface MerchantApi {
    /**
     * 创建交易
     * @param productId 产品id
     * @param dataExchangeReqs 数据交易请求
     * @return 具有唯一性的数据请求id
     */
    @POST("/api/request/create/{productId}")
    Call<JSONObject> dataExchange(@Path("productId") Integer productId, @Body List<DataExchangeReq> dataExchangeReqs);

    /**
     * 根据数据请求id查询交易结果数据
     * @param requestId 数据请求id
     * @return 交易结果数据
     */
    @GET("/api/request/{requestId}")
    Call<DataExchangeDto> getExchangeData(@Path("requestId") String requestId);

    /**
     * 获取产品信息
     * @param productId 产品id
     * @return
     */
    @GET("/api/product/{productId}")
    Call<ProductResultDto> getProduct(@Path("productId") Integer productId);
}
