package com.gxb.sdk.des.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liruobin
 * @since 2018/4/26 下午12:02
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    /**
     * true表示查询成功，false表示由于参数等相关问题无法正常查询到数据；false的情况不会收费
     */
    private boolean success;
    /**
     * 数据源的接口返回数据
     */
    private Object data;
}
