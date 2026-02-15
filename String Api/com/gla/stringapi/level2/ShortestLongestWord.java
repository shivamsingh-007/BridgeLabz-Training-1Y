package com.gla.stringapi.level2;

import java.util.Scanner;

public class ShortestLongestWord {
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

    static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    static int[] findShortestLongest(String[][] wordData) {
        int shortestIndex = 0;
        int longestIndex = 0;
        for (int i = 1; i < wordData.length; i++) {
            if (Integer.parseInt(wordData[i][1]) < Integer.parseInt(wordData[shortestIndex][1])) {
                shortestIndex = i;
            }
            if (Integer.parseInt(wordData[i][1]) > Integer.parseInt(wordData[longestIndex][1])) {
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        String[] words = splitWords(text);
        String[][] wordData = wordsWithLengths(words);
        int[] indexes = findShortestLongest(wordData);
        System.out.println("Shortest word: " + wordData[indexes[0]][0] + " (length " + wordData[indexes[0]][1] + ")");
        System.out.println("Longest word: " + wordData[indexes[1]][0] + " (length " + wordData[indexes[1]][1] + ")");
        scanner.close();
    }
}
