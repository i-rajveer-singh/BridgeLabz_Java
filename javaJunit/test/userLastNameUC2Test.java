/*
 * UserLastNameValidatorUC2Test tests last name validation for user registration.
 * Covers happy and sad test cases using JUnit 5 for UC2.
 * Validates capital start and minimum 3 character requirement.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserLastNameValidatorUC2Test {

    UserLastNameValidatorUC2 validator = new UserLastNameValidatorUC2();

    @Test
        // Happy: valid last name should pass
    void givenValidLastName_ShouldReturnTrue() {
        assertTrue(validator.isValidLastName("Kumar"));
    }

    @Test
        // Sad: lowercase start should fail
    void givenLastNameStartingWithSmallLetter_ShouldReturnFalse() {
        assertFalse(validator.isValidLastName("kumar"));
    }

    @Test
        // Sad: less than 3 characters should fail
    void givenLastNameWithLessThanThreeCharacters_ShouldReturnFalse() {
        assertFalse(validator.isValidLastName("Ku"));
    }

    @Test
        // Sad: null should fail
    void givenNullLastName_ShouldReturnFalse() {
        assertFalse(validator.isValidLastName(null));
    }
}