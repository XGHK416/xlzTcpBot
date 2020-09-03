package com.xghk416.manager.components;

import com.xghk416.manager.BaseCommand;
import com.xghk416.qq.BaseQq;
import com.xghk416.qq.PrivateQqMessage;

import java.util.ArrayList;

public interface PrivateMessageCommand extends BaseCommand {
    String run(PrivateQqMessage qqInfo, ArrayList<String> commandParameter);
}
