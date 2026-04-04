package com.gla.wrapperclass;

import java.util.ArrayList;
import java.util.Objects;

public class ProductRatingsAnalyzer {
    public static void main(String[] args) {
        int[] primitiveRatings = {4, 5, 3, 4};

        ArrayList<Integer> wrapperRatings = new ArrayList<>();
        wrapperRatings.add(5);
        wrapperRatings.add(null);
        wrapperRatings.add(3);
        wrapperRatings.add(null);
        wrapperRatings.add(4);

        ArrayList<Integer> allRatings = new ArrayList<>();

        for (int r : primitiveRatings) {
            allRatings.add(r);
        }

        for (Integer r : wrapperRatings) {
            allRatings.add(r);
        }

        System.out.println("All Ratings (with nulls): " + allRatings);

        int sum = 0;
        int count = 0;

        for (Integer rating : allRatings) {
            if (Objects.nonNull(rating)) {
                sum += rating;
                count++;
            }
        }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Total Valid Ratings: " + count);
            System.out.println("Average Rating: " + average);
        } else {
            System.out.println("No valid ratings found.");
        }
    }
}
