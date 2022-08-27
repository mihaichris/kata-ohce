package com.tv.ohce.repliers;

import java.util.Locale;

public class ReplyPalindrome {
    public static String to(String input) {
        String response = null;
        if (isPalindrome(input)) {
            response = "¡Bonita palabra!";
        }
        return response;
    }

    private static boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input.replaceAll("\\s+", "").toLowerCase(Locale.ROOT)).reverse().toString();
        return input.replaceAll("\\s+", "").toLowerCase(Locale.ROOT).equals(reversed);
    }
}
