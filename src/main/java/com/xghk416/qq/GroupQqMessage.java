package com.xghk416.qq;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

public class GroupQqMessage extends BaseQq{
    private String msg;
    private long fromGroup;
    private long anonymous;

    public GroupQqMessage(String data) {
        super(data);
        JSONObject json = JSONObject.parseObject(data);
        this.fromGroup = json.getLong("fromGroup");
        this.msg = json.getString("msg");
    }

    public void setAnonymous(long anonymous) {
        this.anonymous = anonymous;
    }

    public String getMsg() {
        return msg;
    }

    public long getFromGroup() {
        return fromGroup;
    }

    public long getAnonymous() {
        return anonymous;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setFromGroup(long fromGroup) {
        this.fromGroup = fromGroup;
    }

    @Override
    public String toString() {

        return "GroupQqMessage{" +
                "msg='" + msg + '\'' +
                ", fromGroup=" + fromGroup +
                ", anonymous=" + anonymous +
                ", selfQq=" + super.getSelfQq() +
                ", fromQq=" + super.getFromQq() +
                ", receiveType=" + super.getReceiveType() +
                ", sendType=" + super.getSendType() +
                '}';
    }
}
