package ru.filemanager;


import ru.filemanager.commands.CommandController;
import ru.filemanager.commands.HistoryCommand;
import ru.filemanager.commands.util.CommandStorage;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var controller = new CommandController();
        Scanner scanner = new Scanner(System.in);
        var storage = new CommandStorage();
        String input;
        controller.register("history", new HistoryCommand(storage));
        do {

            System.out.print("> ");
            input = scanner.nextLine();
            storage.putCommandInStorage(input);
            if ("exit".equals(input)) break;
            var token = input.trim().split("\\s+");
            if (token.length == 0) continue;
            var cmdName = token[0];
            try {
                var cmd = controller.getCommand(cmdName);
                String[] arg = Arrays.copyOfRange(token, 1, token.length);
                cmd.execute(arg);
            } catch (RuntimeException ex){
                System.out.println(ex.getMessage());
            }

        } while (true);

    }


}