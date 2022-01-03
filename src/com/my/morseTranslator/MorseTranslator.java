package com.my.morseTranslator;

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
        String newText = "";
        char selectedChar;
        String convertedChar;
        for (int i = 0; i < trimText.length(); i++) {
            selectedChar = trimText.charAt(i);
            // encode the selected char
            convertedChar = encode(Character.toString(selectedChar));
            if (convertedChar.equals(" ")) {
                newText += "| ";
            } else {
                newText += convertedChar + " ";
            }
        }

        return newText.trim();
    }

    public static String morseToEnglish(String text) {
        String trimText = text.trim();

        // variables
        String english = "";
        String selectedEnglish;
        String convertedEnglish;
        // Divide the words in the String array
        String[] morseChars = trimText.split(" ");
        for (String morseChar : morseChars) {
            selectedEnglish = morseChar;
            boolean endsWithWordSeparator = selectedEnglish.endsWith("|");
            // remove the Separator
            if (endsWithWordSeparator) selectedEnglish = selectedEnglish.substring(0, selectedEnglish.length() - 1);
            // decode
            convertedEnglish = decode(selectedEnglish);

            english += convertedEnglish;
            if (endsWithWordSeparator) {
                english += " ";
            }
        }

        return english.trim();
    }

    public static void speak(String s) throws InterruptedException {
        char currentChar;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (currentChar == '.') {
                Thread.sleep(500);
                SoundEffects.dit();
            } else if (currentChar == '-') {
                Thread.sleep(500);
                SoundEffects.dah();
            } else if (currentChar == '|') {
                Thread.sleep(500);
            } else if (currentChar == ' ') {
                Thread.sleep(200);
            }
        }
    }

}
