package com.xghk416.qq;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

public abstract class BaseQq {

    private long selfQq;
    private long fromQq;
    /**
     * 接受状态
     */
    private int receiveType;
    /**
     * 发送状态
     */
    private int sendType;

    public BaseQq(String data) {
        JSONObject json = JSONObject.parseObject(data);
        this.receiveType = json.getInteger("type");
        this.selfQq = json.getLong("selfQQ");
        this.fromQq = json.getLong("fromQQ");
    }

    public int getReceiveType() {
        return receiveType;
    }

    public long getSelfQq() {
        return selfQq;
    }

    public long getFromQq() {
        return fromQq;
    }

    public int getSendType() {
        return sendType;
    }

    public void setSelfQq(long selfQq) {
        this.selfQq = selfQq;
    }

    public void setFromQq(long fromQq) {
        this.fromQq = fromQq;
    }

    public void setReceiveType(int receiveType) {
        this.receiveType = receiveType;
    }

    public void setSendType(int sendType) {
        this.sendType = sendType;
    }
}
