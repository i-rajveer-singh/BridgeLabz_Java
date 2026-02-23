import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserFirstNameValidatorUC1Test {

    UserFirstNameValidatorUC1 validator = new UserFirstNameValidatorUC1();

    @Test
    void givenValidFirstName_ShouldReturnTrue() {
        assertTrue(validator.isValidFirstName("Aaditya"));
    }

    @Test
    void givenFirstNameStartingWithSmallLetter_ShouldReturnFalse() {
        assertFalse(validator.isValidFirstName("aaditya"));
    }

    @Test
    void givenFirstNameWithLessThanThreeCharacters_ShouldReturnFalse() {
        assertFalse(validator.isValidFirstName("Ad"));
    }

    @Test
    void givenNullFirstName_ShouldReturnFalse() {
        assertFalse(validator.isValidFirstName(null));
    }
}