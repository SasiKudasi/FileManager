package ru.filemanager.commands;

import ru.filemanager.commands.util.PathContext;

import java.io.*;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2){
            System.out.println("invalid command, cp <file from> <file to>");
            return;
        }
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


        File targetFile = new File(targetDir, source.getName());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> copy(source, targetFile));

        executorService.shutdown();
    }

    public static void copy(File source, File targetFile) {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[8192]; // считывается по блокам
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("Copy is done: " + targetFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("copy error: " + e.getMessage());
        }
    }
}
