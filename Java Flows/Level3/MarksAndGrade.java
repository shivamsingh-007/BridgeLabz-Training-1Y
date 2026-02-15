import java.util.Scanner;

public class MarksAndGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks in Physics: ");
        double physics = scanner.nextDouble();
        System.out.print("Enter marks in Chemistry: ");
        double chemistry = scanner.nextDouble();
        System.out.print("Enter marks in Maths: ");
        double maths = scanner.nextDouble();
        double average = (physics + chemistry + maths) / 3;
        System.out.println("Average Marks = " + average);
        String grade;
        String remarks;
        if (average >= 90) {
            grade = "A+";
            remarks = "Outstanding";
        } else if (average >= 80) {
            grade = "A";
            remarks = "Excellent";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Very Good";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Good";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Average";
        } else {
            grade = "F";
            remarks = "Fail";
        }
        System.out.println("Grade = " + grade);
        System.out.println("Remarks = " + remarks);
        scanner.close();
    }
}
