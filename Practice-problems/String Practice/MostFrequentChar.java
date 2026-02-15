import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        char maxChar = text.charAt(0);
        int maxCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == current) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = current;
            }
        }
        System.out.println("Most Frequent Character: '" + maxChar + "' (appears " + maxCount + " times)");
        scanner.close();
    }
}
