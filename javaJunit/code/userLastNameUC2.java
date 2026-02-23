/*
 * UserLastNameValidatorUC2 handles validation logic for last name during user registration.
 * It ensures the last name starts with a capital letter and has at least 3 characters.
 * Part of BridgeLabz User Registration system - UC2.
 */
public class UserLastNameValidatorUC2 {

    // Regex: starts with uppercase, followed by at least 2 more letters
    private static final String LAST_NAME_PATTERN = "^[A-Z][a-zA-Z]{2,}$";

    public boolean isValidLastName(String lastName) {
        if (lastName == null) return false;
        return lastName.matches(LAST_NAME_PATTERN);
    }
}
