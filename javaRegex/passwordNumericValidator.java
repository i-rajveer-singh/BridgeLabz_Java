package regex;
/**
 * PasswordRule3Validator - Validates password has at least 1 numeric digit
 * Rule 3: Password must contain at least one numeric digit
 */
import java.util.Scanner;

public class PasswordRule3Validator {

    // Validates password contains at least one numeric digit
    public static boolean validatePasswordRule3(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$";
        return password != null && password.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (validatePasswordRule3(password)) {
            System.out.println("Valid! Password has at least 1 numeric digit.");
        } else {
            System.out.println("Invalid! Password must have at least 1 numeric digit.");
        }

        scanner.close();
    }
}