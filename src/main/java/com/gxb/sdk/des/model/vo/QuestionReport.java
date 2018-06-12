package com.gxb.sdk.des.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liruobin
 * @since 2018/6/8 上午10:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionReport {
    /**
     * 题目id
     */
    private Integer questionId;
    /**
     * 题目内容
     */
    private String content;
    /**
     * 选项
     */
    private List<QuestionOption> options = new ArrayList<>();
    /**
     * 答案
     */
    private String answer;
    /**
     * 用户的选择
     */
    private String choice;

    /**
     * 是否正确
     * @return
     */
    public boolean isRight() {
        return StringUtils.equals(answer, choice);
    }
}
