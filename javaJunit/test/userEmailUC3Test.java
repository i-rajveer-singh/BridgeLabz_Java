/*
 * UserEmailValidatorUC3Test tests email validation for user registration.
 * Covers happy and sad test cases using JUnit 5 for UC3.
 * Validates mandatory parts (abc, bl, co) and optional parts (xyz, in).
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserEmailValidatorUC3Test {

    UserEmailValidatorUC3 validator = new UserEmailValidatorUC3();

    @Test
        // Happy: full valid email with optional parts
    void givenValidEmailWithAllParts_ShouldReturnTrue() {
        assertTrue(validator.isValidEmail("abc.xyz@bl.co.in"));
    }

    @Test
        // Happy: valid email without optional parts
    void givenValidEmailWithMandatoryPartsOnly_ShouldReturnTrue() {
        assertTrue(validator.isValidEmail("abc@bl.co"));
    }

    @Test
        // Sad: missing @ symbol should fail
    void givenEmailWithoutAtSymbol_ShouldReturnFalse() {
        assertFalse(validator.isValidEmail("abcxyz.bl.co.in"));
    }

    @Test
        // Sad: missing domain should fail
    void givenEmailWithoutDomain_ShouldReturnFalse() {
        assertFalse(validator.isValidEmail("abc@"));
    }

    @Test
        // Sad: null should fail
    void givenNullEmail_ShouldReturnFalse() {
        assertFalse(validator.isValidEmail(null));
    }
}