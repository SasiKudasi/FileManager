package ru.filemanager.commands;

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ListCommand implements Command {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void execute(String[] args) {
        Path pwd = Path.of(args[0]);
        if (pwd.toFile().isDirectory()) {
            System.out.printf("%-30s %-5s %-5s %-5s %-20s%n", "NAME", "TYPE", "READ", "WRITE", "LAST MODIFIED");
            System.out.println("=".repeat(70));
            for (File item : Objects.requireNonNull(pwd.toFile().listFiles())) {
                char type = item.isDirectory() ? 'D' : 'F';
                String formattedDate = sdf.format(new Date(item.lastModified()));
                char read = item.canRead() ? 'R' : ' ';
                char write = item.canWrite() ? 'W' : ' ';


                System.out.printf("%-30s %-5s %-5s %-5s %-20s%n",  item.getName(), type, read, write, formattedDate);
            }
        }
    }
}
