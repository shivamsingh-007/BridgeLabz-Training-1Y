import java.util.Scanner;

public class NumberGuessingGame {
    static int generateGuess(int low, int high) {
        return (low + high) / 2;
    }

    static String getUserFeedback(Scanner scanner) {
        System.out.print("Is the guess high, low, or correct? ");
        return scanner.next().toLowerCase();
    }

    static int[] updateRange(int guess, String feedback, int low, int high) {
        if (feedback.equals("high")) {
            high = guess - 1;
        } else if (feedback.equals("low")) {
            low = guess + 1;
        }
        return new int[]{low, high};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        System.out.println("Think of a number between 1 and 100.");
        while (low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("My guess is: " + guess);
            String feedback = getUserFeedback(scanner);
            if (feedback.equals("correct")) {
                System.out.println("I guessed it!");
                break;
            }
            int[] range = updateRange(guess, feedback, low, high);
            low = range[0];
            high = range[1];
        }
        scanner.close();
    }
}
