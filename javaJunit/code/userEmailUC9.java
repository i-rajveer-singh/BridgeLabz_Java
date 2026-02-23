/*
 * UserEmailValidatorUC9 handles comprehensive email validation for user registration.
 * Validates all email rules including TLD, special characters, dots, and @ symbol rules.
 * Part of BridgeLabz User Registration system - UC9.
 */
public class UserEmailValidatorUC9 {

    // Regex: strict rules - no double dots, no leading/trailing dots, max one dot in domain extension
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9][a-zA-Z0-9+_-]*(\\.[a-zA-Z0-9+_-]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?\\.[a-zA-Z]{2,}$";

    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.matches(EMAIL_PATTERN);
    }
}