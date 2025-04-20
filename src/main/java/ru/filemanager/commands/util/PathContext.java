package ru.filemanager.commands.util;

import java.io.File;

public final class PathContext {
    private File currentDir;
    private static PathContext instans;

    private PathContext() {
        this.currentDir = new File(System.getProperty("user.dir"));
    }

    public static PathContext getInstance() {
        if (instans == null) {
            instans = new PathContext();
        }
        return instans;
    }

    public File getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(File dir) {
        this.currentDir = dir;
    }

    public String getCurrentPath() {
        return currentDir.getAbsolutePath();
    }


}
