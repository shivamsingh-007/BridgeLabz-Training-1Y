import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter years of service: ");
        int yearsOfService = scanner.nextInt();
        if (yearsOfService > 5) {
            double bonus = salary * 5 / 100;
            System.out.println("Bonus amount = " + bonus);
        } else {
            System.out.println("No bonus. Years of service must be more than 5.");
        }
        scanner.close();
    }
}
