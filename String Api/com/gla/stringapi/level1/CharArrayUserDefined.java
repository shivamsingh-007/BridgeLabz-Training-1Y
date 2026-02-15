package com.gla.stringapi.level1;

import java.util.Scanner;

public class CharArrayUserDefined {
    static char[] getCharArray(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        char[] userDefined = getCharArray(text);
        char[] builtIn = text.toCharArray();
        boolean match = compareCharArrays(userDefined, builtIn);
        System.out.println("User-defined result: " + new String(userDefined));
        System.out.println("Built-in toCharArray result: " + new String(builtIn));
        System.out.println("Both results match: " + match);
        scanner.close();
    }
}
