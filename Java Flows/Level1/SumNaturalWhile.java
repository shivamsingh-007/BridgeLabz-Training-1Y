import java.util.Scanner;

public class SumNaturalWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number > 0) {
            int formulaResult = number * (number + 1) / 2;
            int loopResult = 0;
            int i = 1;
            while (i <= number) {
                loopResult = loopResult + i;
                i++;
            }
            System.out.println("Sum using formula = " + formulaResult);
            System.out.println("Sum using while loop = " + loopResult);
            System.out.println("Both results are equal: " + (formulaResult == loopResult));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        scanner.close();
    }
}
