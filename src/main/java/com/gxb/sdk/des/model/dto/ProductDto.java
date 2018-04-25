package com.gxb.sdk.des.model.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author liruobin
 * @since 2018/3/29 下午1:50
 */
public class ProductDto implements Serializable{
    private static final long serialVersionUID = 1811543292496673290L;
    /**
     * 产品id
     */
    private Integer productId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 描述
     */
    private String briefDesc;
    /**
     * 类别id
     */
    private String categoryId;
    /**
     * 交易费用
     */
    private PriceDto price;
    /**
     * 数据源id list
     */
    private List<String> datasources;
    /**
     * 发行方
     */
    private String issuer;
    /**
     * 是否涉及隐私
     */
    private Boolean privacy;
    /**
     * 入参定义
     */
    private Map<String,FieldInfo> input;
    /**
     * 出参定义
     */
    private Map<String,FieldInfo> output;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public PriceDto getPrice() {
        return price;
    }

    public void setPrice(PriceDto price) {
        this.price = price;
    }

    public List<String> getDatasources() {
        return datasources;
    }

    public void setDatasources(List<String> datasources) {
        this.datasources = datasources;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    public Map<String, FieldInfo> getInput() {
        return input;
    }

    public void setInput(Map<String, FieldInfo> input) {
        this.input = input;
    }

    public Map<String, FieldInfo> getOutput() {
        return output;
    }

    public void setOutput(Map<String, FieldInfo> output) {
        this.output = output;
    }
}
