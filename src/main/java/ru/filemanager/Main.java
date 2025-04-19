package ru.filemanager;


import ru.filemanager.commands.CommandController;

public class Main {
    public static void main(String[] args) {
        var controller = new CommandController();
        var cmd = controller.getCommand("mv");
        String[] arg = {"D:\\Program Files (x86)\\git\\JAVA\\log-monitoring\\src\\main\\resources\\test", "D:\\Program Files (x86)\\git\\JAVA\\log-monitoring\\src\\main\\resources\\testdir2\\"};
        cmd.execute(arg);
    }
}