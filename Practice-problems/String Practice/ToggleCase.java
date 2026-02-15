import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result = result + (char) (c + 32);
            } else if (c >= 'a' && c <= 'z') {
                result = result + (char) (c - 32);
            } else {
                result = result + c;
            }
        }
        System.out.println("Toggled string: " + result);
        scanner.close();
    }
}
