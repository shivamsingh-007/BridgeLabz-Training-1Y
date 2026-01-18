import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base of the triangle in cm: ");
        double baseCm = input.nextDouble();

        System.out.print("Enter the height of the triangle in cm: ");
        double heightCm = input.nextDouble();

        double areaCm = 0.5 * baseCm * heightCm;
        double areaIn = areaCm / (2.54 * 2.54);

        System.out.println("The area of the triangle is " + areaCm + " square centimeters.");

        input.close();
    }
}