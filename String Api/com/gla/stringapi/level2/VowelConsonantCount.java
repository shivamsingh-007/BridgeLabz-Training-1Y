package com.gla.stringapi.level2;

import java.util.Scanner;

public class VowelConsonantCount {
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

    static int[] findVowelConsonantCount(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = checkVowelConsonant(text.charAt(i));
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        int[] counts = findVowelConsonantCount(text);
        System.out.println("Vowel count = " + counts[0]);
        System.out.println("Consonant count = " + counts[1]);
        scanner.close();
    }
}
