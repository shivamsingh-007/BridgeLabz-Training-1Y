public class PasswordStrengthValidator {

    public static void main(String[] args) {
        String[] passwords = {"abc", "password123", "Str0ng@Pass!", "weak"};

        for (String password : passwords) {
            boolean isStrong = SecurityUtils.isPasswordStrong(password);
            System.out.println("Password: " + password + " | Strong: " + isStrong);
        }
    }
}

interface SecurityUtils {
    static boolean isPasswordStrong(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
