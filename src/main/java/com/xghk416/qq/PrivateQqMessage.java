package com.xghk416.qq;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PrivateQqMessage extends BaseQq{
//    撤回消息用
    private String msg;
    private long random;
    private long req;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getRandom() {
        return random;
    }

    public void setRandom(long random) {
        this.random = random;
    }

    public long getReq() {
        return req;
    }

    public void setReq(long req) {
        this.req = req;
    }

    public PrivateQqMessage(String data) {
        super(data);
        JSONObject json = JSONObject.parseObject(data);
        this.msg = json.getString("msg");
        this.random = json.getLong("random");
        this.req = json.getLong("req");
    }

    @Override
    public String toString() {
        return "PrivateQqMessage{" +
                "msg='" + msg + '\'' +
                ", random=" + random +
                ", req=" + req +
                '}';
    }
}
