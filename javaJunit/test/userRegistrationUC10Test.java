/*
 * UserRegistrationValidatorUC10Test tests all user registration fields together.
 * Covers happy and sad test cases for First Name, Last Name, Email, Mobile, Password.
 * Uses JUnit 5 for UC10 combined validation testing.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationValidatorUC10Test {

    UserRegistrationValidatorUC10 validator = new UserRegistrationValidatorUC10();

    // ===================== FIRST NAME TESTS =====================

    @Test
        // Happy: valid first name should pass
    void givenValidFirstName_ShouldReturnTrue() {
        assertTrue(validator.isValidFirstName("Aaditya"));
    }

    @Test
        // Sad: lowercase start should fail
    void givenInvalidFirstName_ShouldReturnFalse() {
        assertFalse(validator.isValidFirstName("aaditya"));
    }

    // ===================== LAST NAME TESTS =====================

    @Test
        // Happy: valid last name should pass
    void givenValidLastName_ShouldReturnTrue() {
        assertTrue(validator.isValidLastName("Kumar"));
    }

    @Test
        // Sad: less than 3 characters should fail
    void givenInvalidLastName_ShouldReturnFalse() {
        assertFalse(validator.isValidLastName("Ku"));
    }

    // ===================== EMAIL TESTS =====================

    @Test
        // Happy: valid email should pass
    void givenValidEmail_ShouldReturnTrue() {
        assertTrue(validator.isValidEmail("abc@yahoo.com"));
    }

    @Test
        // Sad: missing @ symbol should fail
    void givenInvalidEmail_ShouldReturnFalse() {
        assertFalse(validator.isValidEmail("abcyahoo.com"));
    }

    // ===================== MOBILE TESTS =====================

    @Test
        // Happy: valid mobile with country code should pass
    void givenValidMobile_ShouldReturnTrue() {
        assertTrue(validator.isValidMobile("91 9919819801"));
    }

    @Test
        // Sad: missing space between country code and number should fail
    void givenInvalidMobile_ShouldReturnFalse() {
        assertFalse(validator.isValidMobile("919919819801"));
    }

    // ===================== PASSWORD TESTS =====================

    @Test
        // Happy: password satisfying all rules should pass
    void givenValidPassword_ShouldReturnTrue() {
        assertTrue(validator.isValidPassword("Hello@12"));
    }

    @Test
        // Sad: no uppercase letter should fail
    void givenPasswordWithoutUpperCase_ShouldReturnFalse() {
        assertFalse(validator.isValidPassword("hello@12"));
    }

    @Test
        // Sad: no special character should fail
    void givenPasswordWithoutSpecialChar_ShouldReturnFalse() {
        assertFalse(validator.isValidPassword("Hello123"));
    }

    @Test
        // Sad: less than 8 characters should fail
    void givenPasswordLessThanEightChars_ShouldReturnFalse() {
        assertFalse(validator.isValidPassword("He@1"));
    }
}