package com.gxb.sdk.des.model.dto;

import com.gxb.sdk.des.model.enums.DataExchangeStatusEnum;

import java.io.Serializable;
import java.util.List;

/**
 * 数据交易结果
 * @author liruobin
 * @since 2018/3/27 下午9:52
 */
public class DataExchangeDto implements Serializable{
    private static final long serialVersionUID = -6717454907181016405L;
    /**
     * 状态
     */
    private DataExchangeStatusEnum status;
    /**
     * 数据源数量
     */
    private Integer total;
    /**
     * 反馈的数据
     */
    private List<DataExchangeDetailDto> datasources;

    public DataExchangeStatusEnum getStatus() {
        return status;
    }

    public void setStatus(DataExchangeStatusEnum status) {
        this.status = status;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DataExchangeDetailDto> getDatasources() {
        return datasources;
    }

    public void setDatasources(List<DataExchangeDetailDto> datasources) {
        this.datasources = datasources;
    }
}
