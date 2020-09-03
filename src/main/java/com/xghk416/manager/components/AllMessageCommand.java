package com.xghk416.manager.components;

import com.xghk416.manager.BaseCommand;
import com.xghk416.qq.BaseQq;

import java.util.ArrayList;

public interface AllMessageCommand extends BaseCommand {
    String run(BaseQq qqInfo, ArrayList<String> commandParameter);
}
