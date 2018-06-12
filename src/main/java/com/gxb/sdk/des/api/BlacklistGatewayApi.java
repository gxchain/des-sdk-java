package com.gxb.sdk.des.api;

import com.gxb.sdk.des.model.param.GetQuestionReportParam;
import com.gxb.sdk.des.model.param.GetTokenParam;
import com.gxb.sdk.des.model.vo.QuestionReport;
import com.gxb.sdk.des.model.vo.QuestionTokenResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 黑名单智能网关接口
 * @author liruobin
 * @since 2018/6/8 下午12:15
 */
public interface BlacklistGatewayApi {
    /**
     * 获取答题token
     * @param param
     * @return
     */
    @POST("/blacklist/token")
    Call<QuestionTokenResult> getToken(@Body GetTokenParam param);

    /**
     * 获取答题报告
     * @param param
     * @return
     */
    @POST("/blacklist/question/report")
    Call<List<QuestionReport>> getQuestionReport(@Body GetQuestionReportParam param);
}
