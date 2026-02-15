import java.util.Scanner;

public class AnagramStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = scanner.next().toLowerCase();
        System.out.print("Enter second string: ");
        String s2 = scanner.next().toLowerCase();
        boolean isAnagram = true;
        if (s1.length() != s2.length()) {
            isAnagram = false;
        } else {
            int[] freq = new int[256];
            for (int i = 0; i < s1.length(); i++) {
                freq[s1.charAt(i)]++;
            }
            for (int i = 0; i < s2.length(); i++) {
                freq[s2.charAt(i)]--;
            }
            for (int i = 0; i < 256; i++) {
                if (freq[i] != 0) {
                    isAnagram = false;
                    break;
                }
            }
        }
        if (isAnagram) {
            System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are anagrams.");
        } else {
            System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are not anagrams.");
        }
        scanner.close();
    }
}
