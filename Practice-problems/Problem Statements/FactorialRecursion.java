import java.util.Scanner;

public class FactorialRecursion {
    static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            long result = factorial(number);
            System.out.println("Factorial of " + number + " = " + result);
        }
        scanner.close();
    }
}
