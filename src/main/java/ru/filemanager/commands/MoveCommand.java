package ru.filemanager.commands;

import ru.filemanager.commands.util.PathContext;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoveCommand implements Command {

    @Override
    public void execute(String[] args) {
        Path currentDir = PathContext.getInstance().getCurrentDir().toPath();

        Path sourcePath = currentDir.resolve(args[0]).normalize();
        File source = sourcePath.toFile();

        if (!source.exists() || !source.isFile()) {
            System.out.println("it is not file");
            return;
        }

        Path targetPath = currentDir.resolve(args[1]).normalize();
        File targetDir = targetPath.toFile();

        if (!targetDir.exists()) {
            if (!targetDir.mkdirs()) {
                System.out.println("cannot create dir");
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
