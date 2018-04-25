package com.gxb.sdk.des.client;

import com.gxb.sdk.des.core.GxbApiFactory;

/**
 * @author liruobin
 * @since 2018/3/29 下午5:29
 */
public abstract class DESClient {
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 账号id
     */
    private String accountId;

    GxbApiFactory gxbApiFactory;

    public DESClient(String privateKey,String accountId) {
        //TODO 待确认
        gxbApiFactory = GxbApiFactory.builder().baseUrl("https://des.gxchain.cn").build();
        this.privateKey = privateKey;
        this.accountId = accountId;
    }

    public DESClient(String privateKey,String accountId,String baseUrl) {
        gxbApiFactory = GxbApiFactory.builder().baseUrl(baseUrl).build();
        this.privateKey = privateKey;
        this.accountId = accountId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
