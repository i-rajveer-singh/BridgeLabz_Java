/*
 * UserEmailValidatorUC9Test uses JUnit 5 Parameterised tests to validate multiple email entries.
 * Covers all valid and invalid email samples provided by BridgeLabz for UC9 and UC11.
 * Uses @MethodSource to supply both valid and invalid email test data.
 */
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class UserEmailValidatorUC9Test {

    UserEmailValidatorUC9 validator = new UserEmailValidatorUC9();

    // Valid emails from sample list provided by BridgeLabz
    static Stream<String> validEmailProvider() {
        return Stream.of(
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        );
    }

    // Invalid emails from sample list - abc@gmail.com.com removed as it is valid
    static Stream<String> invalidEmailProvider() {
        return Stream.of(
                "abc",                      // missing @ symbol
                "abc@.com.my",             // tld cannot start with dot
                "abc123@gmail.a",          // tld must have at least 2 characters
                "abc123@.com",             // tld cannot start with dot
                "abc123@.com.com",         // tld cannot start with dot
                ".abc@abc.com",            // email cannot start with dot
                "abc()@gmail.com",         // special chars not allowed
                "abc@%*.com",              // tld only allows char and digit
                "abc..2002@gmail.com",     // double dots not allowed
                "abc.@gmail.com",          // cannot end with dot before @
                "abc@abc@gmail.com",       // double @ not allowed
                "abc@gmail.com.1a",        // 2 char tld cannot contain digit
                "abc@gmail.com.aa.au"      // multiple tlds not allowed
        );
    }

    @ParameterizedTest
    // Happy: all valid emails should return true
    @MethodSource("validEmailProvider")
    void givenValidEmail_ShouldReturnTrue(String email) {
        assertTrue(validator.isValidEmail(email));
    }

    @ParameterizedTest
    // Sad: all invalid emails should return false
    @MethodSource("invalidEmailProvider")
    void givenInvalidEmail_ShouldReturnFalse(String email) {
        assertFalse(validator.isValidEmail(email));
    }
}