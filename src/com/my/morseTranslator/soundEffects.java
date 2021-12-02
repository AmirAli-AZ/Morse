package com.my.morseTranslator;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class soundEffects {
    public static void generateTone(int hz , int msecs , int vloume , boolean addHarmonic) throws LineUnavailableException{
        float frequency = 44100;
        byte[] buf;
        AudioFormat af;
        if(addHarmonic) {
            buf = new byte[2];
            af = new AudioFormat(frequency, 8 , 2 , true , false);
        }else {
            buf = new byte[1];
            af = new AudioFormat(frequency, 8 , 1 , true , false);
        }
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        //sdl = AudioSystem.getSourceDataLine(af);
        sdl.open();
        sdl.start();
        for(int i = 0; i < msecs * frequency / 1000; i++) {
            double angle = i / (frequency / hz) * 2.0 * Math.PI;
            buf[0] = (byte)(Math.sin(angle) * vloume);

            if(addHarmonic) {
                double angle2 = (i)/(frequency /hz) * 2.0 * Math.PI;
                buf[1] = (byte)(Math.sin(2.0 * angle2) * vloume);
                sdl.write(buf, 0, 2);
            }else {
                sdl.write(buf, 0, 1);
            }
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }
    public static void dit(){
        try {
            generateTone(400, 220, (int)(25 * 1.28), true);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void dah(){
        try {
            generateTone(400, 440, (int)(25 * 1.28), true);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
