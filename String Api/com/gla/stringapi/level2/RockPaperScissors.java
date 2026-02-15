package com.gla.stringapi.level2;

import java.util.Scanner;

public class RockPaperScissors {
    static String getComputerChoice() {
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            return "rock";
        } else if (random == 1) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    static String findWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "draw";
        }
        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("scissors") && computer.equals("paper")) ||
            (player.equals("paper") && computer.equals("rock"))) {
            return "player";
        }
        return "computer";
    }

    static String[][] getStats(int playerWins, int computerWins, int draws, int totalGames) {
        double playerPct = (double) playerWins / totalGames * 100;
        double computerPct = (double) computerWins / totalGames * 100;
        String[][] stats = new String[2][3];
        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.valueOf(Math.round(playerPct * 100.0) / 100.0) + "%";
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf(Math.round(computerPct * 100.0) / 100.0) + "%";
        return stats;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int games = scanner.nextInt();
        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;
        System.out.println("Game | Player   | Computer | Winner");
        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String playerChoice = scanner.next();
            String computerChoice = getComputerChoice();
            String winner = findWinner(playerChoice, computerChoice);
            if (winner.equals("player")) {
                playerWins++;
            } else if (winner.equals("computer")) {
                computerWins++;
            } else {
                draws++;
            }
            System.out.println((i + 1) + "    | " + playerChoice + "   | " + computerChoice + "    | " + winner);
        }
        String[][] stats = getStats(playerWins, computerWins, draws, games);
        System.out.println("Stats:");
        System.out.println("Player    | Wins: " + stats[0][1] + " | Win%: " + stats[0][2]);
        System.out.println("Computer  | Wins: " + stats[1][1] + " | Win%: " + stats[1][2]);
        System.out.println("Draws: " + draws);
        scanner.close();
    }
}
