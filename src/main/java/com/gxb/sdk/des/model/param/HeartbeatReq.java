package com.gxb.sdk.des.model.param;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liruobin
 * @since 2018/3/26 上午10:10
 */
@Data
public class HeartbeatReq implements Serializable {

    private static final long serialVersionUID = 6249921560211030015L;
    /**
     * 账号
     */
    private String account;
    /**
     * 支持的产品id列表
     */
    private List<Integer> products;
    /**
     * 过期时间
     */
    private Long timestamp;
    /**
     * 数据源数据查询地址
     */
    private String queryUrl;
    /**
     * 签名
     */
    private String signature;

    public String toSignatureString() {
        return String.format("%s|%s|%s|%s", account, JSON.toJSONString(products), queryUrl, timestamp);
    }

}
