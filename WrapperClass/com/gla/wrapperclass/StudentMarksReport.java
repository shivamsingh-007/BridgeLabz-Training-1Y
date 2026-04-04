package com.gla.wrapperclass;

import java.util.ArrayList;

public class StudentMarksReport {
    public static void main(String[] args) {
        String input1 = "85";
        int input2 = 95;
        Integer input3 = Integer.valueOf(88);
        String input4 = "null";
        String input5 = "abc";
        String input6 = "72";

        ArrayList<Integer> validMarks = new ArrayList<>();

        try {
            validMarks.add(Integer.parseInt(input1));
        } catch (NumberFormatException e) {
            System.out.println("Skipping invalid: " + input1);
        }

        validMarks.add(input2);

        validMarks.add(input3);

        if (!input4.equals("null")) {
            try {
                validMarks.add(Integer.parseInt(input4));
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid: " + input4);
            }
        } else {
            System.out.println("Skipping null entry");
        }

        try {
            validMarks.add(Integer.parseInt(input5));
        } catch (NumberFormatException e) {
            System.out.println("Skipping invalid: " + input5);
        }

        try {
            validMarks.add(Integer.parseInt(input6));
        } catch (NumberFormatException e) {
            System.out.println("Skipping invalid: " + input6);
        }

        System.out.println("Valid Marks: " + validMarks);

        int sum = 0;
        for (Integer mark : validMarks) {
            sum += mark;
        }

        double average = (double) sum / validMarks.size();
        System.out.println("Average Marks: " + average);
    }
}
