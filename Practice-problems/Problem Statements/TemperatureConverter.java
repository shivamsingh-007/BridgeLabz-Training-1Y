import java.util.Scanner;

public class TemperatureConverter {
    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose conversion:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = scanner.nextDouble();
            System.out.println(fahrenheit + " F = " + fahrenheitToCelsius(fahrenheit) + " C");
        } else if (choice == 2) {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = scanner.nextDouble();
            System.out.println(celsius + " C = " + celsiusToFahrenheit(celsius) + " F");
        } else {
            System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
