import java.util.Scanner;

public class FibonacciSequence {
    static void printFibonacci(int terms) {
        int a = 0;
        int b = 1;
        System.out.print("Fibonacci Sequence: ");
        for (int i = 0; i < terms; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int terms = scanner.nextInt();
        printFibonacci(terms);
        scanner.close();
    }
}
