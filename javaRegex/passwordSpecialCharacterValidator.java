package regex;
/**
 * PasswordRule4Validator - Validates password has exactly 1 special character
 * Rule 4: Password must contain exactly one special character
 */
import java.util.Scanner;

public class PasswordRule4Validator {

    // Validates password contains exactly one special character along with other rules
    public static boolean validatePasswordRule4(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check all rules: min 8 chars, 1 uppercase, 1 digit, exactly 1 special char
        boolean hasMinLength = password.length() >= 8;
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");

        // Count special characters
        int specialCharCount = 0;
        String specialChars = "!@#$%^&*()_+-=[]{}|;:',.<>?/~`";
        for (char c : password.toCharArray()) {
            if (specialChars.indexOf(c) != -1) {
                specialCharCount++;
            }
        }

        return hasMinLength && hasUpperCase && hasDigit && specialCharCount == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (validatePasswordRule4(password)) {
            System.out.println("Valid! Password meets all requirements.");
        } else {
            System.out.println("Invalid! Password must have: min 8 chars, 1 uppercase, 1 digit, exactly 1 special character.");
        }

        scanner.close();
    }
}