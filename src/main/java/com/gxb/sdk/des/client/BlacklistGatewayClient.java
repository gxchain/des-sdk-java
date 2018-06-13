package com.gxb.sdk.des.client;

import com.gxb.sdk.des.api.BlacklistGatewayApi;
import com.gxb.sdk.des.exception.GxbApiException;
import com.gxb.sdk.des.model.LoanInfo;
import com.gxb.sdk.des.model.param.GetQuestionReportParam;
import com.gxb.sdk.des.model.param.GetTokenParam;
import com.gxb.sdk.des.model.vo.QuestionReport;
import com.gxb.sdk.des.model.vo.QuestionTokenResult;
import com.gxchain.common.signature.SignatureUtil;

import java.io.IOException;
import java.util.List;

/**
 * 黑名单智能网关client
 *
 * @author liruobin
 * @since 2018/6/8 下午12:13
 */
public class BlacklistGatewayClient extends DESClient {

    private BlacklistGatewayApi blacklistGatewayApi;

    public BlacklistGatewayClient(String privateKey, String accountId) {
        super(privateKey, accountId, "https://survey.gxb.io");
        blacklistGatewayApi = gxbApiFactory.newApi(BlacklistGatewayApi.class);
    }

    public BlacklistGatewayClient(String privateKey, String accountId, String baseUrl) {
        super(privateKey, accountId, baseUrl);
        blacklistGatewayApi = gxbApiFactory.newApi(BlacklistGatewayApi.class);
    }

    /**
     * 获取答题token
     *
     * @param requestId    des交易请求id（黑名单共债请求的id）
     * @param redirectUrl  答题完成后重定向url
     * @param loanInfoList 借款信息
     * @return
     * @throws IOException
     * @throws GxbApiException
     */
    public QuestionTokenResult getQuestionToken(String requestId, String redirectUrl, List<LoanInfo> loanInfoList) throws IOException, GxbApiException {
        GetTokenParam getTokenParam = GetTokenParam.builder().
                requestId(requestId).
                redirectUrl(redirectUrl).
                loanInfos(loanInfoList).
                timestamp(System.currentTimeMillis() + 60000).
                build();

        getTokenParam.setSignature(SignatureUtil.signature(getTokenParam.toSignatureStr().getBytes(), getPrivateKey()));
        return blacklistGatewayApi.getToken(getTokenParam).execute().body();
    }

    /**
     * 获取答题报告
     *
     * @param token 答题token
     * @return
     * @throws IOException
     * @throws GxbApiException
     */
    public List<QuestionReport> getQuestionReport(String token) throws IOException, GxbApiException {
        GetQuestionReportParam getQuestionReportParam = GetQuestionReportParam.builder().
                token(token).
                timestamp(System.currentTimeMillis() + 60000).
                build();
        getQuestionReportParam.setSignature(SignatureUtil.signature(getQuestionReportParam.toSignatureStr().getBytes(), getPrivateKey()));
        return blacklistGatewayApi.getQuestionReport(getQuestionReportParam).execute().body();
    }
}
