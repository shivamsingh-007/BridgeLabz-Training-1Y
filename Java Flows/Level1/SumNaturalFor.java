import java.util.Scanner;

public class SumNaturalFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number > 0) {
            int formulaResult = number * (number + 1) / 2;
            int loopResult = 0;
            for (int i = 1; i <= number; i++) {
                loopResult = loopResult + i;
            }
            System.out.println("Sum using formula = " + formulaResult);
            System.out.println("Sum using for loop = " + loopResult);
            System.out.println("Both results are equal: " + (formulaResult == loopResult));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        scanner.close();
    }
}
