package com.xghk416;

import com.sun.net.httpserver.HttpServer;
import com.xghk416.manager.CommandManager;
import com.xghk416.manager.EventManager;
import com.xghk416.manager.MessageManager;
import com.xghk416.pojo.CommandPrefix;
import com.xghk416.receiver.NfHttpServer;

import java.io.IOException;
import java.net.Socket;

public class XghkBot{
    private final NfHttpServer httpServer;
    private MessageManager messageManager;
    private CommandManager commandManager;
    private EventManager eventManager;

    public XghkBot(String host,int port) {
        this.httpServer = new NfHttpServer(host,port,this);
        this.commandManager = new CommandManager(this);
    }
    public void start(){
        this.httpServer.start();
    }
    public CommandManager getCommandManager(){
        return this.commandManager;
    }
}
