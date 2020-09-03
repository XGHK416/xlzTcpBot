package com.xghk416.qq;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class Result {

    public Result(BaseQq data) {
        if (data instanceof GroupQqMessage){
            GroupMessageResult((GroupQqMessage) data);
        }else if (data instanceof PrivateQqMessage){
            PrivateMessageResult((PrivateQqMessage)data);
        }
    }

    public static JSONObject PrivateMessageResult(PrivateQqMessage data) {
        JSONObject json = new JSONObject();
        json.put("type", data.getSendType());
        json.put("selfQQ", data.getSelfQq());
        json.put("fromQQ", data.getFromQq());
        json.put("msg", data.getMsg());
        json.put("random", data.getRandom());
        json.put("req", data.getReq());
        return json;
    }

    public static JSONObject GroupMessageResult(GroupQqMessage data){
        JSONObject json = new JSONObject();
        json.put("type", data.getSendType());
        json.put("selfQQ", data.getSelfQq());
        json.put("fromGroup",  data.getFromGroup());
        json.put("msg", data.getMsg());
        json.put("anonymous", data.getAnonymous());
        return json;
    }
}
