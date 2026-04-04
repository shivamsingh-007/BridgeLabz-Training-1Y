package com.gla.wrapperclass;

public class GameScoreboard {
    public static void main(String[] args) {
        Integer[] scores = {150, null, 320, null, 210, 400, null, 175};

        int notPlayedCount = 0;
        int totalScore = 0;

        for (Integer score : scores) {
            if (score == null) {
                notPlayedCount++;
            } else {
                totalScore += score;
            }
        }

        System.out.println("Total Players: " + scores.length);
        System.out.println("Players who have not played: " + notPlayedCount);
        System.out.println("Players with valid scores: " + (scores.length - notPlayedCount));
        System.out.println("Total of Valid Scores: " + totalScore);
    }
}
