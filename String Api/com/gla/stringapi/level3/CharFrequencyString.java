package com.gla.stringapi.level3;

import java.util.Scanner;

public class CharFrequencyString {
    static String[] findCharFrequency(String text) {
        char[] chars = text.toCharArray();
        int len = chars.length;
        int[] frequency = new int[len];
        for (int i = 0; i < len; i++) {
            frequency[i] = 1;
            for (int j = 0; j < i; j++) {
                if (chars[j] == chars[i]) {
                    frequency[i]++;
                    chars[j] = '0';
                }
            }
        }
        int validCount = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                validCount++;
            }
        }
        String[] result = new String[validCount];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index] = "'" + chars[i] + "' : " + frequency[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        String[] result = findCharFrequency(text);
        System.out.println("Character | Frequency");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        scanner.close();
    }
}
