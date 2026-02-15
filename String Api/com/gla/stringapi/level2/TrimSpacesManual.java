package com.gla.stringapi.level2;

import java.util.Scanner;

public class TrimSpacesManual {
    static int[] findTrimPoints(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end + 1};
    }

    static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }
        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text (with leading/trailing spaces): ");
        String text = scanner.nextLine();
        int[] points = findTrimPoints(text);
        String manualTrimmed = createSubstring(text, points[0], points[1]);
        String builtInTrimmed = text.trim();
        boolean match = compareStrings(manualTrimmed, builtInTrimmed);
        System.out.println("Manual trimmed = '" + manualTrimmed + "'");
        System.out.println("Built-in trim() = '" + builtInTrimmed + "'");
        System.out.println("Both results match: " + match);
        scanner.close();
    }
}
