package com.gxb.sdk.des.model.dto;

import java.io.Serializable;

/**
 * @author liruobin
 * @since 2018/3/29 下午4:43
 */
public class PriceDto implements Serializable{
    private static final long serialVersionUID = 2786160453048161789L;
    /**
     * 金额
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
