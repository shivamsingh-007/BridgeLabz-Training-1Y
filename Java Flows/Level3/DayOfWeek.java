public class DayOfWeek {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        if (m == 1 || m == 2) {
            m = m + 12;
            y = y - 1;
        }

        int k = y % 100;
        int j = y / 100;

        int h = (d + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) - (2 * j)) % 7;

        int dayOfWeek = ((h + 5) % 7 + 1) % 7;

        System.out.println("Day of the week: " + dayOfWeek);
    }
}
