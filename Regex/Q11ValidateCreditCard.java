public class Q11ValidateCreditCard {
    public static void main(String[] args) {
        String[] cardNumbers = {"4123456789012345", "5123456789012345", "6123456789012345", "412345678901234"};
        String regex = "^(4\\d{15}|5\\d{15})$";

        for (String card : cardNumbers) {
            boolean isValid = card.matches(regex);
            System.out.println(card + " -> " + (isValid ? "Valid" : "Invalid"));
        }
    }
}