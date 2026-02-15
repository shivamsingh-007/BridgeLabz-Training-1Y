import java.util.Scanner;

public class ReplaceWord {
    static String replace(String sentence, String oldWord, String newWord) {
        String result = "";
        int i = 0;
        while (i <= sentence.length() - oldWord.length()) {
            boolean match = true;
            for (int j = 0; j < oldWord.length(); j++) {
                if (sentence.charAt(i + j) != oldWord.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result = result + newWord;
                i = i + oldWord.length();
            } else {
                result = result + sentence.charAt(i);
                i++;
            }
        }
        while (i < sentence.length()) {
            result = result + sentence.charAt(i);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();
        System.out.print("Enter word to replace: ");
        String oldWord = scanner.next();
        System.out.print("Enter new word: ");
        String newWord = scanner.next();
        System.out.println("Modified sentence: " + replace(sentence, oldWord, newWord));
        scanner.close();
    }
}
