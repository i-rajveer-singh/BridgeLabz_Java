/*
 * UserPasswordValidatorUC5678 handles all password validation rules for user registration.
 * Rules: min 8 chars, at least 1 uppercase, at least 1 numeric, exactly 1 special character.
 * Part of BridgeLabz User Registration system - UC5, UC6, UC7, UC8.
 */
public class UserPasswordValidatorUC5678 {

    // Rule 1: minimum 8 characters
    public boolean hasMinEightCharacters(String password) {
        if (password == null) return false;
        return password.length() >= 8;
    }

    // Rule 2: at least one uppercase letter
    public boolean hasUpperCase(String password) {
        if (password == null) return false;
        return password.matches(".*[A-Z].*");
    }

    // Rule 3: at least one numeric digit
    public boolean hasNumericDigit(String password) {
        if (password == null) return false;
        return password.matches(".*[0-9].*");
    }

    // Rule 4: exactly one special character
    public boolean hasExactlyOneSpecialCharacter(String password) {
        if (password == null) return false;
        return password.replaceAll("[^!@#$%^&*]", "").length() == 1;
    }

    // All rules must pass for password to be valid
    public boolean isValidPassword(String password) {
        return hasMinEightCharacters(password) &&
                hasUpperCase(password) &&
                hasNumericDigit(password) &&
                hasExactlyOneSpecialCharacter(password);
    }
}