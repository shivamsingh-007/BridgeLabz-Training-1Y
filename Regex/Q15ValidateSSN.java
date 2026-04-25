public class Q15ValidateSSN {
    public static void main(String[] args) {
        String[] ssns = {"123-45-6789", "123456789"};
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        for (String ssn : ssns) {
            boolean isValid = ssn.matches(regex);
            System.out.println(ssn + " -> " + (isValid ? "Valid" : "Invalid"));
        }
    }
}