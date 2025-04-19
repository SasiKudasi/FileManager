package ru.filemanager.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandController {
    private final Map<String, Command> commandMap;

    public CommandController(){
        commandMap = new HashMap<>();
        register();
    }

    private void register(){
        commandMap.put("ls",        new ListCommand());
        commandMap.put("cp",        new CopyCommand());
        commandMap.put("delete",    new DeleteCommand());
        commandMap.put("mv",        new MoveCommand());
        commandMap.put("find",      new FindCommand());
        commandMap.put("exit",      new ExitCommand());
    }


    public Command getCommand(String commandName){
        var cmd = commandMap.get(commandName);
        if (cmd != null)
            return cmd;
        else {
            throw new RuntimeException("ЗАВЕСТИ КАСТОМНЫЙ ЕКСЕПШЕН");
        }
    }


}
