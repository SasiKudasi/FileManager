package ru.filemanager.commands;

import ru.filemanager.commands.util.PathContext;

import java.io.File;
import java.nio.file.Path;

public class FindCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) return;
        Path currentDir = PathContext.getInstance().getCurrentDir().toPath();
        Path startPath = currentDir.resolve(args[0]).normalize();
        File file = startPath.toFile();
        String pt = args[1];

        findFile(file, pt);

    }

    private void findFile(File dir, String filename) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                findFile(file, filename);
            } else if (file.getName().equals(filename)) {
                System.out.println("Found: " + file.getAbsolutePath());
            }
        }
    }
}

