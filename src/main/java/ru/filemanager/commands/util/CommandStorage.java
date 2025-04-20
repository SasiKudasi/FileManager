package ru.filemanager.commands.util;

import java.util.ArrayList;
import java.util.List;

public class CommandStorage  {
    private final List <String> storage;

    public CommandStorage() {
        this.storage = new ArrayList<>();
    }

    public void putCommandInStorage (String cmd){
        storage.add(cmd);
    }
    public List<String> getStorage() {
        return storage;
    }
}
