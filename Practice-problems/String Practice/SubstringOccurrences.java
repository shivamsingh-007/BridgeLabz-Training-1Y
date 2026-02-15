import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter main string: ");
        String text = scanner.nextLine();
        System.out.print("Enter substring to search: ");
        String sub = scanner.nextLine();
        int count = 0;
        int index = 0;
        while (index <= text.length() - sub.length()) {
            boolean match = true;
            for (int i = 0; i < sub.length(); i++) {
                if (text.charAt(index + i) != sub.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
                index = index + sub.length();
            } else {
                index++;
            }
        }
        System.out.println("Substring \"" + sub + "\" occurs " + count + " time(s).");
        scanner.close();
    }
}
