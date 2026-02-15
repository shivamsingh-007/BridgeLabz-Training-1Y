import java.util.Scanner;

public class GCDAndLCM {
    static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int findLCM(int a, int b) {
        return (a / findGCD(a, b)) * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        System.out.println("GCD of " + a + " and " + b + " = " + findGCD(a, b));
        System.out.println("LCM of " + a + " and " + b + " = " + findLCM(a, b));
        scanner.close();
    }
}
