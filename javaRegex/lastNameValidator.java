package regex;
/**
 * LastNameValidator - Validates last name input
 * Last name must start with capital letter and have minimum 3 characters
 */
import java.util.Scanner;

public class LastNameValidator {

    // Validates last name - must start with uppercase letter followed by at least 2 lowercase letters
    public static boolean validateLastName(String lastName) {
        String regex = "^[A-Z][a-z]{2,}$";
        return lastName != null && lastName.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        if (validateLastName(lastName)) {
            System.out.println("Valid Last Name!");
        } else {
            System.out.println("Invalid Last Name! Must start with capital letter and have minimum 3 characters.");
        }

        scanner.close();
    }
}