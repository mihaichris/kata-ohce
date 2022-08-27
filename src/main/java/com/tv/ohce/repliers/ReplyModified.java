package com.tv.ohce.repliers;

public class ReplyModified {
    public static String to(String input, Integer index) {
        String response = null;
        if (index == 0) {
            return input;
        } else {
            try {
                String character = Character.toString(input.charAt(index));
                response = modify(input, character);
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return response;
    }

    private static String modify(String input, String character) {
        StringBuilder modified = new StringBuilder();
        String[] parts = input.split("((?<=" + character + ")|(?=" + character + "))");
        String middlePart = parts[(parts.length - 1) / 2];
        for (String part : parts) {
            if (part.equals(middlePart)) {
                modified.append(part);
            } else {
                modified.append(new StringBuilder(part).reverse().toString());
            }
        }
        return modified.toString();
    }
}
