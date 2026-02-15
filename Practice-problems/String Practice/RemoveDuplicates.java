import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == c) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result = result + c;
            }
        }
        System.out.println("String after removing duplicates: " + result);
        scanner.close();
    }
}
