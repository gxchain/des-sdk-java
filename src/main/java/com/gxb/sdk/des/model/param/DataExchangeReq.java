package com.gxb.sdk.des.model.param;

import java.io.Serializable;

/**
 * 数据交易请求参数
 * @author liruobin
 * @since 2018/3/23 下午1:27
 */
public class DataExchangeReq implements Serializable {
    private static final long serialVersionUID = 377073303221867266L;
    /**
     * 商户使用数据源公钥加密请求参数数据包
     */
    private String params;
    /**
     *
     */
    private RequestParams requestParams;


    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public RequestParams getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(RequestParams requestParams) {
        this.requestParams = requestParams;
    }
}
