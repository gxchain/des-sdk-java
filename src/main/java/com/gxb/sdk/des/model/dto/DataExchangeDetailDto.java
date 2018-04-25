package com.gxb.sdk.des.model.dto;

import com.gxb.sdk.des.model.enums.DataExchangeDetailStatusEnum;

import java.io.Serializable;

/**
 * 数据交易明细数据
 * @author liruobin
 * @since 2018/3/27 下午9:53
 */
public class DataExchangeDetailDto implements Serializable {

    private static final long serialVersionUID = -7431809969000679692L;
    /**
     * 数据状态
     */
    private DataExchangeDetailStatusEnum status;
    /**
     * 提示说明
     */
    private String comment;
    /**
     * 数据源id
     */
    private String datasource;
    /**
     * 商户公钥加密的数据
     */
    private String data;
    /**
     * 区块id
     */
    private String txid;

    public DataExchangeDetailStatusEnum getStatus() {
        return status;
    }

    public void setStatus(DataExchangeDetailStatusEnum status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }
}
