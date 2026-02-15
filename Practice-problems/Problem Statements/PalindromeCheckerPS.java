import java.util.Scanner;

public class PalindromeCheckerPS {
    static String getInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.next();
    }

    static boolean isPalindrome(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static void displayResult(String text, boolean result) {
        if (result) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = getInput(scanner);
        boolean result = isPalindrome(text);
        displayResult(text, result);
        scanner.close();
    }
}
