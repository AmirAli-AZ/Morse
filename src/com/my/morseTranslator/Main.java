package com.my.morseTranslator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=================================");
        System.out.println("Morse Translator By Amir Ali");
        int count = 0;
        while (count < 3){
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            String translate = MorseTranslator.englishToMorse(input);
            System.out.println("Converted English : " + translate);
            MorseTranslator.speak(translate);
            count++;
        }
    }
}