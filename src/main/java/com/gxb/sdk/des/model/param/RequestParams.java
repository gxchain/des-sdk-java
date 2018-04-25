package com.gxb.sdk.des.model.param;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.primitives.Bytes;
import com.gxchain.common.ws.client.graphenej.objects.AssetAmount;
import com.gxchain.common.ws.client.graphenej.objects.UserAccount;

import java.io.Serializable;
import java.util.List;

/**
 * @author liruobin
 * @since 2018/3/23 下午1:34
 */
public class RequestParams implements Serializable {
    /**
     * 从该账户转账，商户账户
     */
    private String from;
    /**
     * 转账至该账户，数据源账户
     */
    private String to;
    /**
     * 代理记账方
     */
    private String proxyAccount;
    /**
     * amount的百分比，转至proxy_account
     */
    private int percent;
    /**
     * 转账数量
     */
    private Amount amount;
    /**
     * 请求参数的MD5值
     */
    private String memo;
    /**
     * 授权过期日期
     */
    private long expiration;
    /**
     * 签名
     */
    List<String> signatures;

    /**
     * 签名用
     * @return
     */
    public byte[] toBytes() {
        byte[] fromBytes = new UserAccount(from).toBytes();
        byte[] toBytes = new UserAccount(to).toBytes();
        byte[] proxyAccountBytes = new UserAccount(proxyAccount).toBytes();
        byte[] amountBytes = new AssetAmount(amount.getAmount(), amount.getAssetId()).toBytes();
        byte[] percentBytes = new byte[] {(byte) percent, (byte) (percent >> 8)};
        byte[] memoPrefixBytes = new byte[] {(byte) memo.length()};
        byte[] memoBytes = memo.getBytes();
        byte[] expirationBytes = new byte[] {(byte) expiration, (byte) (expiration >> 8), (byte) (expiration >> 16), (byte) (expiration >> 24)};
        return Bytes.concat(fromBytes, toBytes, proxyAccountBytes, amountBytes, percentBytes, memoPrefixBytes, memoBytes, expirationBytes, new byte[] {0});
    }


    public String toJsonString(){
        return JSON.toJSONString(this, SerializerFeature.SortField);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getProxyAccount() {
        return proxyAccount;
    }

    public void setProxyAccount(String proxyAccount) {
        this.proxyAccount = proxyAccount;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }
}
