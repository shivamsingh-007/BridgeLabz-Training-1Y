public class Q2ValidateLicensePlate {
    public static void main(String[] args) {
        String[] plates = {"AB1234", "A12345"};
        String regex = "^[A-Z]{2}\\d{4}$";

        for (String plate : plates) {
            boolean isValid = plate.matches(regex);
            System.out.println(plate + " -> " + (isValid ? "Valid" : "Invalid"));
        }
    }
}