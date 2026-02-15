import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter height in cm: ");
        double heightCm = scanner.nextDouble();
        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);
        System.out.println("BMI = " + bmi);
        String weightStatus;
        if (bmi < 18.5) {
            weightStatus = "Underweight";
        } else if (bmi < 25.0) {
            weightStatus = "Normal weight";
        } else if (bmi < 30.0) {
            weightStatus = "Overweight";
        } else {
            weightStatus = "Obese";
        }
        System.out.println("Weight Status = " + weightStatus);
        scanner.close();
    }
}
