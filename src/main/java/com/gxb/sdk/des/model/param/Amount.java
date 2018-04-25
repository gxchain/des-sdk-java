package com.gxb.sdk.des.model.param;

import java.io.Serializable;

/**
 * @author liruobin
 * @since 2018/3/23 下午1:37
 */
public class Amount implements Serializable {
    /**
     * 转账金额
     */
    private Long amount;
    /**
     * 资产id
     */
    private String assetId;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
