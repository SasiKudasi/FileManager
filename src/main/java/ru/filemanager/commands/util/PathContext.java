package ru.filemanager.commands.util;

import java.io.File;

public final class PathContext {
    private File currentDir;
    private static PathContext instance;

    private PathContext() {
        this.currentDir = new File(System.getProperty("user.dir"));
    }

    public static PathContext getInstance() {
        if (instance == null) {
            instance = new PathContext();
        }
        return instance;
    }

    public File getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(File dir) {
        this.currentDir = dir;
    }

//    public String getCurrentPath() {
//        return currentDir.getAbsolutePath();
//    }


}
