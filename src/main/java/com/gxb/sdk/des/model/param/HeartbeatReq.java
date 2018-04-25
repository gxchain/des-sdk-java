package com.gxb.sdk.des.model.param;

import java.io.Serializable;
import java.util.List;

/**
 * @author liruobin
 * @since 2018/3/26 上午10:10
 */
public class HeartbeatReq implements Serializable {

    private static final long serialVersionUID = 6249921560211030015L;
    /**
     * 账号
     */
    private String account;
    /**
     * 支持的产品id列表
     */
    private List<Integer> products;
    /**
     * 过期时间
     */
    private Long timestamp;
    /**
     * 签名
     */
    private String signature;

    public String toSignatureString(){
        return String.format("%s|%s|%s",account,products,timestamp);
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
