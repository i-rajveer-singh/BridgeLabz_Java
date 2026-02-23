package regex;
/**
 * FirstNameValidator - Validates first name input
 * First name must start with capital letter and have minimum 3 characters
 */
import java.util.Scanner;

public class FirstNameValidator {

    // Validates first name - must start with uppercase letter followed by at least 2 lowercase letters
    public static boolean validateFirstName(String firstName) {
        String regex = "^[A-Z][a-z]{2,}$";
        return firstName != null && firstName.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        if (validateFirstName(firstName)) {
            System.out.println("Valid First Name!");
        } else {
            System.out.println("Invalid First Name! Must start with capital letter and have minimum 3 characters.");
        }

        scanner.close();
    }
}