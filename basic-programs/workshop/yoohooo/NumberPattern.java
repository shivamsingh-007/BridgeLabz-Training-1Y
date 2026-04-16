package yoohooo;

public class NumberPattern {
    public static void main(String[] args) {
        int max = 9;

        for (int i = 1; i <= max; i += 2) {
            for (int s = 0; s < (max - i) / 2; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        for (int i = max - 2; i >= 1; i -= 2) {
            for (int s = 0; s < (max - i) / 2; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
