package ru.filemanager.commands;

import ru.filemanager.commands.util.PathContext;

import java.nio.file.Path;

public class ChangeDirCommand implements Command {
    @Override
    public void execute(String[] args) {
        if(args.length != 1) {
            System.out.println("invalid command, ls <path>");
            return;
        }

        Path currentDir = PathContext.getInstance().getCurrentDir().toPath();

        var target  =  currentDir.resolve(args[0]).normalize().toFile();
        if (!target.exists()) {
            System.out.println("Directory does not exist: " + target);
            return;
        }

        if (!target.isDirectory()) {
            System.out.println("It is not a directory: " + target);
            return;
        }
        PathContext.getInstance().setCurrentDir(target);
    }
}
