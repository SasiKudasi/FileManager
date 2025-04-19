package ru.filemanager.commands;

import java.io.File;
import java.util.regex.Pattern;

public class FindCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length <= 0) return;
        String pt = args[1];
        File file = new File(args[0]);
        findFile(file, pt);

    }

    private void findFile(File file, String pattern) {

        if (file.isFile()){
            if (pattern.equals(file.getName())) {
                System.out.println("File " + file.getName() + " was fiend in dir " + file.getAbsolutePath());
                return;
            }
        }

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.getName().equals("gradlew"))
                    System.out.println("GRADLEW HERE");
                if (f.isDirectory()) {
                    findFile(f, pattern);
                } else if (pattern.equals(f.getName())) {
                    System.out.println("File " + f.getName() + " was fiend in dir " + file.getAbsolutePath());
                    return;
                }
            }
        }

    }
}

