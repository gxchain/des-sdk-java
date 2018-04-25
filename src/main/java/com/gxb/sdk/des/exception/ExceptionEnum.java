package com.gxb.sdk.des.exception;


/**
 * @author liruobin
 * @since 2018/3/23 下午5:37
 */
public enum ExceptionEnum implements ExceptionCode {

    INVALID_PARAMS("参数错误"),
    ACCOUNT_NOT_EXIST("账号不存在"),
    FORBIDDEN("已下架"),
    BALANCE_NOT_ENOUGH("余额不足"),
    SIGNATURE_VERIFY_FAIL("验签失败"),
    TIME_OUT("请求超时"),
    DATASOURCE_OFFLINE("数据源离线"),
    DEFAULT_MESSAGE("系统繁忙，请稍后重试"),
    UNKNOWN_ERROR("未知错误")
    ;

    /**
     * 异常信息
     */
    private String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    @Override
    public String getCode(){
        return this.name();
    }
    @Override
    public String getMessage() {
        return message;
    }

    public static ExceptionEnum getByName(String name){
        for (ExceptionEnum item: ExceptionEnum.values()) {
            if(item.name().equals(name)){
                return item;
            }
        }
        return UNKNOWN_ERROR;
    }
}
