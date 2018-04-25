package com.gxb.sdk.des.model.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 数据交易服务对象
 * @author liruobin
 * @since 2018/3/29 下午2:20
 */
public class DataExchangeServiceDto {
    /**
     * 代理转账账号id
     */
    @JSONField(name = "account_id")
    private String accountId;
    /**
     * 转账手续费百分比
     */
    private Integer percent;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }
}
