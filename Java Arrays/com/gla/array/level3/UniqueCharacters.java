package com.gla.array.level3;

import java.util.Scanner;

public class UniqueCharacters {
    static int findLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                return count;
            }
        }
    }

    static char[] findUniqueChars(String text) {
        int len = findLength(text);
        char[] unique = new char[len];
        int uniqueIndex = 0;
        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unique[uniqueIndex] = current;
                uniqueIndex++;
            }
        }
        char[] result = new char[uniqueIndex];
        for (int i = 0; i < uniqueIndex; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        char[] unique = findUniqueChars(text);
        System.out.print("Unique characters: ");
        for (int i = 0; i < unique.length; i++) {
            System.out.print(unique[i] + " ");
        }
        System.out.println();
        scanner.close();
    }
}
