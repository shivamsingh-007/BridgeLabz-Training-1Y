public class Q1ValidateUsername {
    public static void main(String[] args) {
        String[] usernames = {"user_123", "123user", "us"};
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";

        for (String username : usernames) {
            boolean isValid = username.matches(regex);
            System.out.println(username + " -> " + (isValid ? "Valid" : "Invalid"));
        }
    }
}