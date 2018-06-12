package com.gxb.sdk.des.model.vo;

import lombok.Data;

/**
 * @author liruobin
 * @since 2018/6/8 下午12:30
 */
@Data
public class QuestionTokenResult {
    /**
     * 答题token
     */
    private String token;
    /**
     * 答题页面链接
     */
    private String redirectUrl;
}
