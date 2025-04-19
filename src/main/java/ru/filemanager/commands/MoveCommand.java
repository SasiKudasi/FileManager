package ru.filemanager.commands;

public class MoveCommand implements Command {
    @Override
    public void execute(String[] args) {
        var copy = new CopyCommand();
        copy.execute(args);
        var del = new DeleteCommand();
        del.execute(args);
    }
}
