package com.gxb.sdk.des.model.dto;

import com.gxb.sdk.des.model.enums.DataExchangeDetailStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 数据交易明细数据
 * @author liruobin
 * @since 2018/3/27 下午9:53
 */
@Data
public class DataExchangeDetailDto implements Serializable {

    private static final long serialVersionUID = -7431809969000679692L;
    /**
     * 数据状态
     */
    private DataExchangeDetailStatusEnum status;
    /**
     * 提示说明
     */
    private String comment;
    /**
     * 数据源id
     */
    private String datasource;
    /**
     * 商户公钥加密的数据
     */
    private String data;
    /**
     * 数据源
     */
    private Long nonce;
    /**
     * 区块id
     */
    private String txid;
    /**
     * 数据源公钥
     */
    private String datasourcePublicKey;

}
