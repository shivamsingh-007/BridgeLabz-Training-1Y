package com.gla.wrapperclass;

public class UserInputValidation {

    public static boolean isValidAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] testInputs = {"25", "15", "abc", "18", "-5", "100"};

        for (String input : testInputs) {
            boolean result = isValidAge(input);
            System.out.println("Input: \"" + input + "\" -> Valid and 18+: " + result);
        }
    }
}
