/*
 * UserPasswordValidatorUC5678Test tests all password validation rules for user registration.
 * Covers happy and sad cases for all 4 rules using JUnit 5 for UC5, UC6, UC7, UC8.
 * All rules must pass together for a valid password.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserPasswordValidatorUC5678Test {

    UserPasswordValidatorUC5678 validator = new UserPasswordValidatorUC5678();

    @Test
        // Happy: password satisfying all rules should pass
    void givenValidPassword_ShouldReturnTrue() {
        assertTrue(validator.isValidPassword("Hello@12"));
    }

    @Test
        // Sad UC5: less than 8 characters should fail
    void givenPasswordLessThanEightChars_ShouldReturnFalse() {
        assertFalse(validator.isValidPassword("He@1"));
    }

    @Test
        // Sad UC6: no uppercase letter should fail
    void givenPasswordWithoutUpperCase_ShouldReturnFalse() {
        assertFalse(validator.isValidPassword("hello@12"));
    }

    @Test
        // Sad UC7: no numeric digit should fail
    void givenPasswordWithoutNumericDigit_ShouldReturnFalse() {
        assertFalse(validator.isValidPassword("Hello@ab"));
    }

    @Test
        // Sad UC8: no special character should fail
    void givenPasswordWithoutSpecialCharacter_ShouldReturnFalse() {
        assertFalse(validator.isValidPassword("Hello123"));
    }

    @Test
        // Sad UC8: more than one special character should fail
    void givenPasswordWithMoreThanOneSpecialCharacter_ShouldReturnFalse() {
        assertFalse(validator.isValidPassword("Hello@1@"));
    }

    @Test
        // Sad: null password should fail
    void givenNullPassword_ShouldReturnFalse() {
        assertFalse(validator.isValidPassword(null));
    }
}