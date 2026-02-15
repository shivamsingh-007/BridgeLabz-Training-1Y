import java.util.Scanner;

public class PowerOfNumberWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();
        int result = 1;
        int counter = 0;
        while (counter == power) {
            result = result * number;
            counter++;
        }
        System.out.println(number + " raised to the power " + power + " = " + result);
        scanner.close();
    }
}
