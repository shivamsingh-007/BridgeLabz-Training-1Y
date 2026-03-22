public class ThrowVsThrows {
    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        try {
            double interest = calculateInterest(1000, 5, 3);
            System.out.println("Calculated Interest: " + interest);
            double invalid = calculateInterest(-500, 5, 3);
            System.out.println("Calculated Interest: " + invalid);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
