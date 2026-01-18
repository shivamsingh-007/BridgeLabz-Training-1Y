import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = input.nextDouble();

        System.out.print("Enter b: ");
        double b = input.nextDouble();

        System.out.print("Enter c: ");
        double c = input.nextDouble();

        double r1 = a + b * c;
        double r2 = a * b + c;
        double r3 = c + a / b;
        double r4 = a % b + c;

        System.out.println("The results of Double Operations are " + r1 + ", " + r2 + ", " + r3 + ", and " + r4);

        input.close();
    }
}
