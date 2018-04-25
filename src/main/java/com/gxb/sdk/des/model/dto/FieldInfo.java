package com.gxb.sdk.des.model.dto;

import java.io.Serializable;

/**
 * @author liruobin
 * @since 2018/3/29 下午1:57
 */
public class FieldInfo implements Serializable{
    private static final long serialVersionUID = -5261762247133957553L;
    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String desc;
    /**
     * 例子
     */
    private String sample;
    /**
     * 是否必须
     */
    private Boolean required;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }
}
