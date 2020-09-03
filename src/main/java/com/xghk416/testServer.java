package com.xghk416;

public class testServer {
    public static void main(String[] args) {
        XghkBot bot = new XghkBot("127.0.0.1", 8404);
//        bot.getCommandManager().addCommand("apo", new OpResumeCommand()).addCommand("app",new OpResumeCommandPrivate()).addCommand("aps",new OpResumeCommandAll());
        bot.start();
    }
}
