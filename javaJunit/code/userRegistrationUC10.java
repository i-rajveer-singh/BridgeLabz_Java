/*
 * UserRegistrationValidatorUC10 combines all validation logic for user registration.
 * Validates First Name, Last Name, Email, Mobile and Password in a single class.
 * Part of BridgeLabz User Registration system - UC10.
 */
public class UserRegistrationValidatorUC10 {

    // Validates first name: starts with uppercase, minimum 3 characters
    public boolean isValidFirstName(String firstName) {
        if (firstName == null) return false;
        return firstName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // Validates last name: starts with uppercase, minimum 3 characters
    public boolean isValidLastName(String lastName) {
        if (lastName == null) return false;
        return lastName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // Validates email: mandatory parts with correct @ and dot positions
    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.matches("^[a-zA-Z0-9][a-zA-Z0-9+_-]*(\\.[a-zA-Z0-9+_-]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}$");
    }

    // Validates mobile: country code followed by space and 10 digit number
    public boolean isValidMobile(String mobile) {
        if (mobile == null) return false;
        return mobile.matches("^[0-9]{2} [0-9]{10}$");
    }

    // Validates password: min 8 chars, 1 uppercase, 1 digit, exactly 1 special character
    public boolean isValidPassword(String password) {
        if (password == null) return false;
        boolean hasMin8 = password.length() >= 8;
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasOneSpecial = password.replaceAll("[^!@#$%^&*]", "").length() == 1;
        return hasMin8 && hasUpper && hasDigit && hasOneSpecial;
    }
}