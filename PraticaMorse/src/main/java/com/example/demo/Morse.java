package com.example.demo;
import java.util.*;

public class Morse {

    private static final String[] CHARACTER =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V"
                    , "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "?", "!", ".", ","};
    private static final String[] MORSE =
            {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".----", "-.-", ".-..", "--", "-.", "---"
                    , ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----"
                    , "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",
                    "..--..", "-.-.--", ".-.-.-", "--..--"};

    public static String converterEmPt(String text) {
        StringBuilder resultado = new StringBuilder();

        List<String> chars = new ArrayList<String>(Arrays.asList(text.split(" ")));

        for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).equals("") && chars.get(i-1).equals("")) {
                    resultado.append(" ");
                }
            for(int j = 0; j < CHARACTER.length; j++) {
                //System.out.println(chars.get(i) + " ... " + CHARACTER[j]);
                if (chars.get(i).toUpperCase().equals(MORSE[j])) {
                    resultado.append(CHARACTER[j]);
                }
            }
        }
        return resultado.toString();
    }
}
