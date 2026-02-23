/*
 * UserMobileValidatorUC4Test tests mobile number validation for user registration.
 * Covers happy and sad test cases using JUnit 5 for UC4.
 * Validates country code, space, and 10 digit number format.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserMobileValidatorUC4Test {

    UserMobileValidatorUC4 validator = new UserMobileValidatorUC4();

    @Test
        // Happy: valid mobile with country code should pass
    void givenValidMobileNumber_ShouldReturnTrue() {
        assertTrue(validator.isValidMobile("91 9919819801"));
    }

    @Test
        // Sad: missing space between country code and number should fail
    void givenMobileWithoutSpace_ShouldReturnFalse() {
        assertFalse(validator.isValidMobile("919919819801"));
    }

    @Test
        // Sad: less than 10 digits after country code should fail
    void givenMobileWithLessThanTenDigits_ShouldReturnFalse() {
        assertFalse(validator.isValidMobile("91 991981980"));
    }

    @Test
        // Sad: missing country code should fail
    void givenMobileWithoutCountryCode_ShouldReturnFalse() {
        assertFalse(validator.isValidMobile("9919819801"));
    }

    @Test
        // Sad: null should fail
    void givenNullMobile_ShouldReturnFalse() {
        assertFalse(validator.isValidMobile(null));
    }
}