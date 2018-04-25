package com.gxb.sdk.des.model.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author liruobin
 * @since 2018/3/29 下午2:09
 */
public class AccountInfo implements Serializable{
    private static final long serialVersionUID = 3535844188415407386L;
    /**
     * 账户id
     */
    @JSONField(name = "account_id")
    private String accountId;
    /**
     * 公钥
     */
    private String publicKey;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
