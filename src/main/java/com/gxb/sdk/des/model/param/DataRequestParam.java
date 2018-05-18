package com.gxb.sdk.des.model.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liruobin
 * @since 2018/3/27 下午7:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataRequestParam {
    /**
     * 交易请求参数
     */
    private String params;
    /**
     * 加解密随机数
     */
    private Long nonce;
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * 产品id
     */
    private Integer productId;
    /**
     * 商户账号id
     */
    private String merchantAccountId;
}
