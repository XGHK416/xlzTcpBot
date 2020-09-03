package com.xghk416.manager;

import com.xghk416.XghkBot;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
public class CommandManager {
    private XghkBot bot;
    private Map<String,BaseCommand> commandMap = new HashMap<>();
    private String spiltSymbol;

    public CommandManager(XghkBot bot) {
        this.bot = bot;
    }
    public CommandManager addCommand(String prefix,BaseCommand command){
        this.commandMap.put(prefix,command);
        return this;
    }
    public Set<String> getCommandPrefixes(){
        return commandMap.keySet();
    }
    public BaseCommand getCurrentCommand(String currentPrefix){
        return commandMap.get(currentPrefix);
    }

}
