package ru.filemanager.commands;

import ru.filemanager.commands.util.PathContext;

public class PresentWorkingDirCommand implements Command{
    @Override
    public void execute(String[] args) {
        System.out.println( PathContext.getInstance().getCurrentPath());
    }
}
