import java.util.*;

public class MultipleCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int[] array = {10, 20, 30, 40, 50};
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
        scanner.close();
    }
}
