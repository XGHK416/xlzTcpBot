package com.xghk416.manager.components;

import com.xghk416.manager.BaseCommand;
import com.xghk416.qq.BaseQq;
import com.xghk416.qq.GroupQqMessage;

import java.util.ArrayList;

public interface GroupMessageCommand extends BaseCommand {
    String run(GroupQqMessage qqInfo, ArrayList<String> commandParameter);
}
