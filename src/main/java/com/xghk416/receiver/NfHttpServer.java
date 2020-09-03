package com.xghk416.receiver;

import com.alibaba.fastjson.JSONObject;
import com.xghk416.XghkBot;
import com.xghk416.manager.BaseCommand;
import com.xghk416.manager.components.AllMessageCommand;
import com.xghk416.manager.components.GroupMessageCommand;
import com.xghk416.manager.components.PrivateMessageCommand;
import com.xghk416.qq.BaseQq;
import com.xghk416.qq.GroupQqMessage;
import com.xghk416.qq.PrivateQqMessage;
import com.xghk416.qq.Result;
import com.xghk416.util.ListUtil;
import com.xghk416.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NfHttpServer extends Thread{
    Socket socket = null;
    XghkBot bot;
    public NfHttpServer(String host, int port, XghkBot bot) {
        this.bot = bot;
        try {
            //需要服务器的IP地址和端口号，才能获得正确的Socket对象
            socket = new Socket(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        super.run();
        try {
            InputStream s = socket.getInputStream();
            byte[] buf = new byte[128];
            int len = 0;
            String temp = "";
            while ((len = s.read(buf)) != -1) {
                String data = new String(buf, 0, len);
                temp += data;
                if(len < 128){
                    String temp2 = temp;
                    temp = "";
                    parseData(temp2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void parseData(String data){
        if(data.equals("")){
            return;
        }
        data = StringUtils.getURLDecoderString(data);
//        System.out.println(data);
        data = data.replace("^nbsp^", "%");
//        System.out.println(data.charAt(data.length()-1));
        try {
            JSONObject json = JSONObject.parseObject(data);
            String msg = "";
            switch (json.getInteger("type")){
                case 1:{
                    msg = PrivateParse(data);
                    break;
                }
                case 2:{
                    msg =  GroupParse(data);
                    break;
                }
                case 3:{
                    msg = EventParse(data);
                    break;
                }
            }
//        System.out.println(msg);
            sendMsg(msg);
        }catch (Exception e){
            sendMsg("error");
        }


//        System.out.println(data);
    }
    private String PrivateParse(String data){
        String result = "";
        PrivateQqMessage info = new PrivateQqMessage(data);
        String[] strings= info.getMsg().split(" ");
        ArrayList<String> parameters = ListUtil.StringsToArrayList(strings);
        if (bot.getCommandManager().getCommandPrefixes().contains(strings[0])){
            BaseCommand command = bot.getCommandManager().getCurrentCommand(strings[0]);
            if (command instanceof PrivateMessageCommand){
//                群消息命令
                info.setSendType(103);
                result = ((PrivateMessageCommand) command).run(info, parameters);
                info.setMsg(result);
                return Result.PrivateMessageResult(info).toJSONString();
            }else if (command instanceof AllMessageCommand){
//                全局消息命令
                info.setSendType(103);
                result = ((AllMessageCommand) command).run(info, parameters);
                info.setMsg(result);
                return Result.PrivateMessageResult(info).toJSONString();
            }
        }
        return result;

    }
    private String GroupParse(String data){
        String result = "";
        GroupQqMessage info = new GroupQqMessage(data);
        String[] strings= info.getMsg().split(" ");
        ArrayList<String> parameters = ListUtil.StringsToArrayList(strings);
        if (bot.getCommandManager().getCommandPrefixes().contains(strings[0])){
            BaseCommand command = bot.getCommandManager().getCurrentCommand(strings[0]);
            if (command instanceof GroupMessageCommand){
//                群消息命令
                info.setSendType(203);
                info.setAnonymous(0);
                result = ((GroupMessageCommand) command).run(info, parameters);
                info.setMsg(result);
                return Result.GroupMessageResult(info).toJSONString();
            }else if (command instanceof AllMessageCommand){
//                全局消息命令
                info.setSendType(203);
                info.setAnonymous(0);
                result = ((AllMessageCommand) command).run(info, parameters);
                info.setMsg(result);
                return Result.GroupMessageResult(info).toJSONString();
            }
        }
        return result;


    }
    private String EventParse(String data){
        String result = "-----";
        // TODO: 2020/8/15 event
        return result;
    }

    //写操作
    public void sendMsg(String msg){
        OutputStream os= null;
        try {
            os= socket.getOutputStream();
            os.write(msg.getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
