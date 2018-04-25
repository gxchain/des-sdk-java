package com.gxb.sdk.des.api;

import com.alibaba.fastjson.JSONObject;
import com.gxb.sdk.des.model.param.HeartbeatReq;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 数据源api
 * @author liruobin
 * @since 2018/3/29 上午11:57
 */
public interface DataSourceApi {
    /**
     * 数据源心跳检测
     * @param req
     * @return
     */
    @POST("/api/datasource/heartbeat")
    Call<JSONObject> heartBeat(@Body HeartbeatReq req);

    /**
     * 查询数据源公钥
     * @param accountId 账号
     * @return
     */
    @GET("/api/datasource/activePublicKey")
    Call<String> selectDataSourcePublicKey(@Query("accountId") String accountId);
}
