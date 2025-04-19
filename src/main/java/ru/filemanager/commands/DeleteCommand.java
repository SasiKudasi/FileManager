package ru.filemanager.commands;


import java.io.File;

public class DeleteCommand implements Command{
    @Override
    public void execute(String[] args) {
        File source = new File(args[0]);
        if (!source.exists() || !source.isFile()) {
            System.out.println("it is not file");
            return;
        }
        var name= source.getName();
        if(source.delete())
        {
            System.out.println("File " +name+ " was deleted");
        }
    }
}
