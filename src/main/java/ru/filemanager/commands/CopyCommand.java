package ru.filemanager.commands;

import java.io.*;

public class CopyCommand implements Command {
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

        File targetFile = new File(targetDir, source.getName());

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
