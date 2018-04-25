package com.gxb.sdk.des.model.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author liruobin
 * @since 2018/3/29 下午2:26
 */
public class ProductResultDto {
    /**
     * 产品信息
     */
    private ProductDto product;
    /**
     * 数据交易服务服务信息
     */
    private DataExchangeServiceDto des;
    /**
     * 在线数据源
     */
    private List<AccountInfo> onlineDatasources;

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public DataExchangeServiceDto getDes() {
        return des;
    }

    public void setDes(DataExchangeServiceDto des) {
        this.des = des;
    }

    public List<AccountInfo> getOnlineDatasources() {
        return onlineDatasources;
    }

    public void setOnlineDatasources(List<AccountInfo> onlineDatasources) {
        this.onlineDatasources = onlineDatasources;
    }
}
