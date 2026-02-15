import java.util.Scanner;

public class RemoveSpecificChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        System.out.print("Enter character to remove: ");
        char removeChar = scanner.next().charAt(0);
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != removeChar) {
                result = result + text.charAt(i);
            }
        }
        System.out.println("Modified String: \"" + result + "\"");
        scanner.close();
    }
}
