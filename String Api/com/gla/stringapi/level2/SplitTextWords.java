package com.gla.stringapi.level2;

import java.util.Scanner;

public class SplitTextWords {
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

    static String[] splitWords(String text) {
        int len = findLength(text);
        int wordCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;
        int[] spaceIndexes = new int[wordCount];
        int si = 0;
        spaceIndexes[si] = -1;
        si++;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[si] = i;
                si++;
            }
        }
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            int start = spaceIndexes[i] + 1;
            int end = (i + 1 < wordCount) ? spaceIndexes[i + 1] : len;
            String word = "";
            for (int j = start; j < end; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        String[] manual = splitWords(text);
        String[] builtIn = text.split(" ");
        boolean match = compareArrays(manual, builtIn);
        System.out.println("Words (manual method):");
        for (int i = 0; i < manual.length; i++) {
            System.out.println(manual[i]);
        }
        System.out.println("Both results match: " + match);
        scanner.close();
    }
}
