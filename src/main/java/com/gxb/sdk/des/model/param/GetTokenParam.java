package com.gxb.sdk.des.model.param;


import com.gxb.sdk.des.model.LoanInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * 获取token
 * @author liruobin
 * @since 2018/6/6 上午10:20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTokenParam {
    /**
     * des交易请求id
     */
    private String requestId;
    /**
     * 过期时间戳
     */
    private Long timestamp;
    /**
     * 回调地址
     */
    private String redirectUrl;
    /**
     * 签名
     */
    private String signature;
    /**
     * 借款信息
     */
    private List<LoanInfo> loanInfos;

    /**
     * 生成待签名字符串
     * @return
     */
    public String toSignatureStr(){
        StringBuilder stringBuilder = new StringBuilder();
        for (LoanInfo loanInfo: loanInfos){
            stringBuilder.append(loanInfo.toSignatureStr()).append("|");
        }
        return String.format("%s|%s|$s|%s",requestId,timestamp,redirectUrl,stringBuilder.toString());
    }
}
