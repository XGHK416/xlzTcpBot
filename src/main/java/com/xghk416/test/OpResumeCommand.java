package com.xghk416.test;

import com.xghk416.builder.MessageBuilder;
import com.xghk416.manager.components.GroupMessageCommand;
import com.xghk416.pojo.CommandPrefix;
import com.xghk416.qq.BaseQq;
import com.xghk416.qq.GroupQqMessage;

import java.util.ArrayList;

public class OpResumeCommand implements GroupMessageCommand {
    @Override
    public String run(GroupQqMessage qqInfo, ArrayList<String> commandParameter) {
//        System.out.println(qqInfo);
//        System.out.println(qqInfo);
//        System.out.println(commandParameter);
        return new MessageBuilder().add("xxxx").toString();
    }

    @Override
    public CommandPrefix commandPrefix() {
        return new CommandPrefix("apo");
    }
}
