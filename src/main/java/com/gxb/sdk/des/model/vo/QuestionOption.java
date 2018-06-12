package com.gxb.sdk.des.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 题目选项
 * @author liruobin
 * @since 2018/6/6 下午8:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionOption {
    /**
     * 选项值
     */
    private String value;
    /**
     * 选项内容
     */
    private String label;
}
