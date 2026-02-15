import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String longestWord = "";
        String currentWord = "";
        for (int i = 0; i <= sentence.length(); i++) {
            if (i < sentence.length() && sentence.charAt(i) != ' ') {
                currentWord = currentWord + sentence.charAt(i);
            } else {
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
                currentWord = "";
            }
        }
        System.out.println("Longest word: " + longestWord);
        scanner.close();
    }
}
