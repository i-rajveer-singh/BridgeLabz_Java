package regex;
/**
 * PasswordRule1Validator - Validates password has minimum 8 characters
 * Rule 1: Password must have at least 8 characters
 */
import java.util.Scanner;

public class PasswordRule1Validator {

    // Validates password has minimum 8 characters
    public static boolean validatePasswordRule1(String password) {
        String regex = "^.{8,}$";
        return password != null && password.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (validatePasswordRule1(password)) {
            System.out.println("Valid! Password has minimum 8 characters.");
        } else {
            System.out.println("Invalid! Password must have at least 8 characters.");
        }

        scanner.close();
    }
}