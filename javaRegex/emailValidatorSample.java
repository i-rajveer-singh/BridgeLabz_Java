package regex;
/**
 * EmailSampleValidator - Validates email against multiple sample test cases
 * Tests various email formats to ensure comprehensive validation
 */
import java.util.Scanner;

public class EmailSampleValidator {

    // Validates email using comprehensive regex pattern - allows alphanumeric, dot, underscore, plus, and hyphen
    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        return email != null && email.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Valid email test cases from the document
        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        };

        // Invalid email test cases from the document
        String[] invalidEmails = {
                "abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123@.com",
                "abc123@.com.com",
                ".abc@abc.com",
                "abc()*@gmail.com",
                "abc@%*.com",
                "abc..2002@gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        };

        System.out.println("=== Testing Valid Emails ===");
        for (String email : validEmails) {
            boolean result = validateEmail(email);
            System.out.println(email + " : " + result + (result ? " ✓" : " ✗ FAILED"));
        }

        System.out.println("\n=== Testing Invalid Emails ===");
        for (String email : invalidEmails) {
            boolean result = validateEmail(email);
            System.out.println(email + " : " + (!result ? "Correctly Rejected ✓" : "FAILED - Should be Invalid ✗"));
        }

        System.out.print("\n\nEnter your email to validate: ");
        String userEmail = scanner.nextLine();

        if (validateEmail(userEmail)) {
            System.out.println("Valid Email!");
        } else {
            System.out.println("Invalid Email!");
        }

        scanner.close();
    }
}