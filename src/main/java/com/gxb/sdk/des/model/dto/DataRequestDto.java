package com.gxb.sdk.des.model.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author liruobin
 * @since 2018/3/29 下午6:25
 */
public class DataRequestDto implements Serializable{
    private static final long serialVersionUID = 3545809797270974165L;
    /**
     * 加密参数
     */
    private String params;
    /**
     * 请求方公钥
     */
    private String publicKey;
    /**
     * 请求方id
     */
    private Integer productId;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
