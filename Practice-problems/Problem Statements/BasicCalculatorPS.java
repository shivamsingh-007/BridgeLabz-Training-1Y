import java.util.Scanner;

public class BasicCalculatorPS {
    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();
        System.out.println("Choose operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        double result = 0;
        if (choice == 1) {
            result = add(a, b);
            System.out.println("Result = " + result);
        } else if (choice == 2) {
            result = subtract(a, b);
            System.out.println("Result = " + result);
        } else if (choice == 3) {
            result = multiply(a, b);
            System.out.println("Result = " + result);
        } else if (choice == 4) {
            result = divide(a, b);
            System.out.println("Result = " + result);
        } else {
            System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
