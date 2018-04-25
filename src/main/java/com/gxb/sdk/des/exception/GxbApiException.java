package com.gxb.sdk.des.exception;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GxbApiException extends RuntimeException {
    private ExceptionCode exception;
    /**
     *
     */
    private static final long serialVersionUID = 4773709921313688818L;

    public GxbApiException(String errorMessage) {
        super(errorMessage);
        JSONObject error = JSON.parseObject(errorMessage);
        exception = ExceptionEnum.getByName(error.getString("code"));
    }

    public GxbApiException(ExceptionCode exception) {
        super(JSON.toJSONString(exception));
        this.exception = exception;
    }
    public GxbApiException(int errorCode, String errorMessage, String detail) {
        super(String.format("%s,detail:%s", errorMessage, detail));
    }

    public ExceptionCode getException() {
        return exception;
    }

    public void setException(ExceptionCode exception) {
        this.exception = exception;
    }
}
