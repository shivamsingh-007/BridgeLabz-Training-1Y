import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter day: ");
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("Original date: " + date);
        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2);
        System.out.println("After adding 7 days, 1 month, 2 years: " + result);
        result = result.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + result);
        scanner.close();
    }
}
