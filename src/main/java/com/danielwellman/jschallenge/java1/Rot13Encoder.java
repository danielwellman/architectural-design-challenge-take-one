package com.danielwellman.jschallenge.java1;

public class Rot13Encoder implements Encoder {

    public String encode(String input) {
        final StringBuilder builder = new StringBuilder(input.length());

        for (int index = 0; index < input.length(); index++) {
            char c = input.charAt(index);
            builder.append(rot13Encode(c));
        }
        return builder.toString();
    }

    private char rot13Encode(char character) {
        if (isLowerHalfOfAlphabet(character)) return (char) (character + 13);
        else if (isUpperHalfOfAlphabet(Character.toLowerCase(character))) return (char) (character - 13);
        else return character;
    }

    private boolean isLowerHalfOfAlphabet(char originalCharacter) {
        final char caseInsensitiveCharacter = Character.toLowerCase(originalCharacter);
        return ('a' <= caseInsensitiveCharacter) && (caseInsensitiveCharacter < 'n');
    }

    private boolean isUpperHalfOfAlphabet(char originalCharacter) {
        final char caseInsensitiveCharacter = Character.toLowerCase(originalCharacter);
        return ('n' <= caseInsensitiveCharacter) && (caseInsensitiveCharacter <= 'z');
    }

}
