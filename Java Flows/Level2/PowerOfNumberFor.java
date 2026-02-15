import java.util.Scanner;

public class PowerOfNumberFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer (number): ");
        int number = scanner.nextInt();
        System.out.print("Enter a positive integer (power): ");
        int power = scanner.nextInt();
        if (number > 0 && power > 0) {
            int result = 1;
            for (int i = 1; i <= power; i++) {
                result = result * number;
            }
            System.out.println(number + " raised to the power " + power + " = " + result);
        } else {
            System.out.println("Please enter positive integers.");
        }
        scanner.close();
    }
}
