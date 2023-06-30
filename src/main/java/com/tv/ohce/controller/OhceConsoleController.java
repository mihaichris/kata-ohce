package com.tv.ohce.controller;

import com.tv.ohce.exception.ChatLengthOutOfRangeException;
import infrastructure.console.Console;
import com.tv.ohce.exception.StopException;
import com.tv.ohce.greet.Greet;
import com.tv.ohce.repliers.ReplyModified;
import com.tv.ohce.repliers.ReplyPalindrome;
import com.tv.ohce.repliers.ReplyReverse;

import java.time.LocalTime;

public class OhceConsoleController {

    private final Console console;
    private Integer index;
    private final Integer maxChatLength;
    private final Integer time;

    public OhceConsoleController(Console console, Integer maxChatLength, Integer time) {
        this.console = console;
        this.maxChatLength = maxChatLength;
        this.time = time;
    }

    public void run(String name) {
        LocalTime localTime;
        if (this.time >= 0 && this.time <= 23) {
            localTime = LocalTime.of(this.time, 0);
        } else {
            console.print("Time must be between 0 and 23.");
            return;
        }
        if (this.maxChatLength <= 0) {
            console.print("Max chat length must not be smaller than 0.");
            return;
        }
        String salute = new Greet(name, localTime).toString();
        this.index = localTime.getHour();
        reply(salute);
        try {
            listenToUser();
        } catch (ChatLengthOutOfRangeException e) {
            console.print("Range of chat reached limits.");
        } catch (StopException e) {
            console.print("Adios " + name);
        }
    }

    public void listenToUser() throws StopException, ChatLengthOutOfRangeException {
        while (true) {
            String userInput = console.read();
            if (userInput.equals("Stop!")) {
                throw new StopException();
            }
            if (userInput.length() > this.maxChatLength || "".equals(userInput)) {
                throw new ChatLengthOutOfRangeException();
            }
            reply(ReplyReverse.to(userInput));
            reply(ReplyPalindrome.to(userInput));
            reply(ReplyModified.to(userInput, this.index));
        }
    }

    private void reply(String reply) {
        if (reply != null) {
            console.print(reply);
        }
    }
}
