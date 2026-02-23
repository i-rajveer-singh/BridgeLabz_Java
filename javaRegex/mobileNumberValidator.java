package regex;
/**
 * MobileNumberValidator - Validates mobile number input
 * Mobile format: country code followed by space and 10 digit number (e.g., 91 9919819801)
 */
import java.util.Scanner;

public class MobileNumberValidator {

    // Validates mobile number - country code, space, and 10 digits
    public static boolean validateMobileNumber(String mobile) {
        String regex = "^[0-9]{1,3}\\s[0-9]{10}$";
        return mobile != null && mobile.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Mobile Number (e.g., 91 9919819801): ");
        String mobile = scanner.nextLine();

        if (validateMobileNumber(mobile)) {
            System.out.println("Valid Mobile Number!");
        } else {
            System.out.println("Invalid Mobile Number! Format: country code + space + 10 digits");
        }

        scanner.close();
    }
}