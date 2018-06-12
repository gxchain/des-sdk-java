package com.gxb.sdk.des.model.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liruobin
 * @since 2018/6/7 下午8:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetQuestionReportParam {
    /**
     * 答题token
     */
    private String token;
    /**
     * 过期时间戳
     */
    private Long timestamp;

    /**
     * 签名
     */
    private String signature;

    /**
     * 待签名的字符串
     * @return
     */
    public String toSignatureStr() {
        return String.format("%s|%s", token, timestamp);
    }
}
