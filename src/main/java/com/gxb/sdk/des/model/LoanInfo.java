package com.gxb.sdk.des.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liruobin
 * @since 2018/6/6 上午10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanInfo {
    /**
     * 数据源id
     */
    private String platform;
    /**
     * 数据源-平台名称
     */
    @JSONField(name = "platform_name")
    private String platformName;
    /**
     * 个人信用
     */
    @JSONField(name = "loan_type")
    private Integer loanType;
    /**
     * 借款状态
     */
    @JSONField(name = "loan_status")
    private Integer loanStatus;
    /**
     * 借款金额区间
     */
    @JSONField(name = "loan_amount")
    private String loanAmount;
    /**
     * 借款合同日期
     */
    @JSONField(name = "contract_date")
    private String contractDate;
    /**
     * 还款状态
     */
    @JSONField(name = "repay_status")
    private String repayStatus;
    /**
     * 欠款金额
     */
    private Double arrears;

    /**
     * 生成待签名字符串
     * @return
     */
    public String toSignatureStr(){
        return String.format("%s|%d|%d|%s|%s|%s|%.2f",platform,loanType,loanStatus,loanAmount,contractDate,repayStatus,arrears);
    }
}
