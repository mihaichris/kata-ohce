package com.tv.ohce;

import infrastructure.console.SystemConsole;
import com.tv.ohce.controller.OhceConsoleController;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        String userName = "Mihai";
        int maxChatLength = 40;
        int time = LocalTime.now().getHour();
        if (args.length != 0) {
            userName = args[0];
            maxChatLength = Integer.parseInt(args[1]);
            time = Integer.parseInt(args[2]);
        }
        OhceConsoleController controller = new OhceConsoleController(new SystemConsole(), maxChatLength, time);
        controller.run(userName);
    }
}
