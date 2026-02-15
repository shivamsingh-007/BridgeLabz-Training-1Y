package com.gla.stringapi.level2;

import java.util.Scanner;

public class VowelConsonantType {
    static String checkVowelConsonant(char c) {
        char lower;
        if (c >= 'A' && c <= 'Z') {
            lower = (char) (c + 32);
        } else {
            lower = c;
        }
        if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
            return "Vowel";
        } else if (lower >= 'a' && lower <= 'z') {
            return "Consonant";
        } else {
            return "Not a Letter";
        }
    }

    static String[][] findCharTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkVowelConsonant(text.charAt(i));
        }
        return result;
    }

    static void displayTable(String[][] data) {
        System.out.println("Character | Type");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "         | " + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        String[][] result = findCharTypes(text);
        displayTable(result);
        scanner.close();
    }
}
