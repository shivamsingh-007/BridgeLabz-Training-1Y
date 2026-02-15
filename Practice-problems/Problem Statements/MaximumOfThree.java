import java.util.Scanner;

public class MaximumOfThree {
    static int[] getInputs(Scanner scanner) {
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        System.out.print("Enter third number: ");
        int c = scanner.nextInt();
        return new int[]{a, b, c};
    }

    static int findMaximum(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = getInputs(scanner);
        int max = findMaximum(inputs[0], inputs[1], inputs[2]);
        System.out.println("Maximum of three numbers = " + max);
        scanner.close();
    }
}
