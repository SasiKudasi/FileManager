package ru.filemanager.commands;


import ru.filemanager.commands.util.PathContext;

import java.io.File;
import java.nio.file.Path;

public class DeleteCommand implements Command{
    @Override
    public void execute(String[] args) {
        if (args.length < 1){
            System.out.println("invalid command, rm <file>");
            return;
        }
        Path currentDir = PathContext.getInstance().getCurrentDir().toPath();

        Path sourcePath = currentDir.resolve(args[0]).normalize();
        File source = sourcePath.toFile();


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
