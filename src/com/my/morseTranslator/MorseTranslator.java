package com.my.morseTranslator;

import java.util.concurrent.TimeUnit;

public class MorseTranslator {

    private static final String[] english = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?"};

    private static final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.."};

    private static final int count = 39;

    public static String encode(String toEncode) {
        String m = toEncode;
        for (int i = 0; i < count; i++) {
            if (toEncode.equalsIgnoreCase(english[i])) {
                m = morse[i];
                break;
            }
        }
        return m;
    }

    public static String decode(String toEncode) {
        if (toEncode.equalsIgnoreCase("|")) {
            return "";
        }
        String e = toEncode;
        for (int i = 0; i < count; i++) {
            if (toEncode.equalsIgnoreCase(morse[i])) {
                e = english[i];
                break;
            }
        }
        return e;
    }

    public static String englishToMorse(String text) {
        String trimText = text.trim();
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < trimText.length(); i++) {
            char selectedChar = trimText.charAt(i);
            // encode the selected char
            String convertedChar = encode(Character.toString(selectedChar));
            if (convertedChar.equals(" ")) {
                newText.append("| ");
            } else {
                if (i == trimText.length() - 1)
                    newText.append(convertedChar);
                else
                    newText.append(convertedChar).append(" ");
            }
        }

        return newText.toString();
    }

    public static String morseToEnglish(String text) {
        String trimText = text.trim();
        StringBuilder english = new StringBuilder();
        // Divide the words in the String array
        String[] morseChars = trimText.split(" ");
        for (String morseChar : morseChars) {
            String selectedEnglish = morseChar;
            boolean endsWithWordSeparator = selectedEnglish.endsWith("|");
            // remove the Separator
            if (endsWithWordSeparator) selectedEnglish = selectedEnglish.substring(0, selectedEnglish.length() - 1);
            // decode
            String convertedEnglish = decode(selectedEnglish);

            english.append(convertedEnglish);
            if (endsWithWordSeparator) {
                english.append(" ");
            }
        }

        return english.toString();
    }

    public static void speak(String s) throws InterruptedException {
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '.') {
                TimeUnit.MILLISECONDS.sleep(500);
                SoundEffects.dit();
            } else if (currentChar == '-') {
                TimeUnit.MILLISECONDS.sleep(500);
                SoundEffects.dah();
            } else if (currentChar == '|') {
                TimeUnit.MILLISECONDS.sleep(500);
            } else if (currentChar == ' ') {
                TimeUnit.MILLISECONDS.sleep(500);
            }
        }
    }

}
