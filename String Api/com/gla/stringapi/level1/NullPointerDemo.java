package com.gla.stringapi.level1;

public class NullPointerDemo {
    static void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Calling method to handle NullPointerException:");
        handleException();
        System.out.println("Calling method to generate NullPointerException:");
        generateException();
    }
}
