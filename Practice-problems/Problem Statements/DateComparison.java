import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first date:");
        System.out.print("Year: ");
        int year1 = scanner.nextInt();
        System.out.print("Month: ");
        int month1 = scanner.nextInt();
        System.out.print("Day: ");
        int day1 = scanner.nextInt();
        System.out.println("Enter second date:");
        System.out.print("Year: ");
        int year2 = scanner.nextInt();
        System.out.print("Month: ");
        int month2 = scanner.nextInt();
        System.out.print("Day: ");
        int day2 = scanner.nextInt();
        LocalDate date1 = LocalDate.of(year1, month1, day1);
        LocalDate date2 = LocalDate.of(year2, month2, day2);
        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is before " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " is after " + date2);
        } else {
            System.out.println(date1 + " is equal to " + date2);
        }
        scanner.close();
    }
}
