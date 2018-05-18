package com.gxb.sdk.des.model.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据交易请求参数
 * @author liruobin
 * @since 2018/3/23 下午1:27
 */
@Data
public class DataExchangeReq implements Serializable {
    private static final long serialVersionUID = 377073303221867266L;
    /**
     * 商户使用数据源公钥加密请求参数数据包
     */
    private String params;
    /**
     * 加解密随机数
     */
    private Long nonce;
    /**
     *
     */
    private RequestParams requestParams;
}
