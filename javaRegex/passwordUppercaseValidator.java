package regex;
/**
 * PasswordRule2Validator - Validates password has at least 1 uppercase letter
 * Rule 2: Password must contain at least one uppercase letter
 */
import java.util.Scanner;

public class PasswordRule2Validator {

    // Validates password contains at least one uppercase letter
    public static boolean validatePasswordRule2(String password) {
        String regex = "^(?=.*[A-Z]).{8,}$";
        return password != null && password.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (validatePasswordRule2(password)) {
            System.out.println("Valid! Password has at least 1 uppercase letter.");
        } else {
            System.out.println("Invalid! Password must have at least 1 uppercase letter.");
        }

        scanner.close();
    }
}