package regex;
/**
 * EmailValidator - Validates email input
 * Email format: abc.xyz@bl.co.in with 3 mandatory parts (abc, bl, co) and 2 optional (xyz, in)
 */
import java.util.Scanner;

public class EmailValidator {

    // Validates email - ensures proper format with mandatory and optional parts
    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        return email != null && email.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        if (validateEmail(email)) {
            System.out.println("Valid Email!");
        } else {
            System.out.println("Invalid Email! Format: abc.xyz@bl.co.in");
        }

        scanner.close();
    }
}