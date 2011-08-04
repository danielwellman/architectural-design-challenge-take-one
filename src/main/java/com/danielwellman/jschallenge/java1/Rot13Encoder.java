package com.danielwellman.jschallenge.java1;

public class Rot13Encoder implements Encoder {

    public static final int OFFSET_OF_UPPERCASE_A = 65;
    public static final int OFFSET_OF_LOWERCASE_A = 97;

    public static final int LETTERS_IN_ALPHABET = 26;

    public String encode(String input) {
        final StringBuilder builder = new StringBuilder(input.length());

        for (int index = 0; index < input.length(); index++) {
            char c = input.charAt(index);
            builder.append(rot13Encode(c));
        }
        return builder.toString();
    }

    private char rot13Encode(char c) {
        if (Character.isUpperCase(c)) {
            return rotate(c, OFFSET_OF_UPPERCASE_A);
        } else if (Character.isLowerCase(c)) {
            return rotate(c, OFFSET_OF_LOWERCASE_A);
        } else {
            return c;
        }
    }

    private char rotate(char c, int offset) {
        return (char) ((((c - offset) + 13) % LETTERS_IN_ALPHABET) + offset);
    }
}
