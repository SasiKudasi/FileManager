package ru.filemanager;


import ru.filemanager.commands.CommandController;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var controller = new CommandController();
        Scanner scanner = new Scanner(System.in);
        String input;
        do {

            System.out.print("> ");
            input = scanner.nextLine();
            if ("exit".equals(input)) break;
            var token = input.trim().split("\\s+");
            if (token.length == 0) continue;
            var cmdName = token[0];
            var cmd = controller.getCommand(cmdName);
            String[] arg = Arrays.copyOfRange(token, 1, token.length);
            cmd.execute(arg);
        } while (true);

    }


}