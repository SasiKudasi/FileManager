package ru.filemanager.commands;

import ru.filemanager.commands.util.CommandStorage;

public class HistoryCommand implements Command {

    private final CommandStorage storage;

    public HistoryCommand(CommandStorage storage) {
        this.storage = storage;
    }

    @Override
    public void execute(String[] args) {
        storage.getStorage()
                .forEach(System.out::println);
    }
}
