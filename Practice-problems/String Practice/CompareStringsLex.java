import java.util.Scanner;

public class CompareStringsLex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();
        int minLen = s1.length() < s2.length() ? s1.length() : s2.length();
        int result = 0;
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                result = -1;
                break;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                result = 1;
                break;
            }
        }
        if (result == 0) {
            if (s1.length() < s2.length()) {
                result = -1;
            } else if (s1.length() > s2.length()) {
                result = 1;
            }
        }
        if (result < 0) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\" in lexicographical order");
        } else {
            System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are equal");
        }
        scanner.close();
    }
}
