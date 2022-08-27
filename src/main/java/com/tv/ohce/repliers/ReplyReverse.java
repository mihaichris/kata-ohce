package com.tv.ohce.repliers;

public class ReplyReverse {
    public static String to(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
