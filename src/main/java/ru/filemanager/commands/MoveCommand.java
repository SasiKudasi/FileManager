package ru.filemanager.commands;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoveCommand implements Command {

    @Override
    public void execute(String[] args) {

        File source = new File(args[0]);
        if (!source.exists() || !source.isFile()) {
            System.out.println("it is not file");
            return;
        }

        File targetDir = new File(args[1]);
        if (!targetDir.exists()) {
            if (!targetDir.mkdirs()) {
                System.out.println("can not create dir");
                return;
            }
        }
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()-> {
            File targetFile = new File(targetDir, source.getName());
            CopyCommand.copy(source, targetFile);
            var del = new DeleteCommand();
            del.execute(args);
        });
        executorService.shutdown();
    }
}
