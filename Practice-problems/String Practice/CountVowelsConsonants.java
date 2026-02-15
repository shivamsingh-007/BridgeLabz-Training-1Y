import java.util.Scanner;

public class CountVowelsConsonants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char lower;
            if (c >= 'A' && c <= 'Z') {
                lower = (char) (c + 32);
            } else {
                lower = c;
            }
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowels++;
            } else if (lower >= 'a' && lower <= 'z') {
                consonants++;
            }
        }
        System.out.println("Vowels = " + vowels);
        System.out.println("Consonants = " + consonants);
        scanner.close();
    }
}
