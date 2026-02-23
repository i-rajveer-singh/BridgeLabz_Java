public class UserFirstNameValidatorUC1 {

    private static final String FIRST_NAME_PATTERN = "^[A-Z][a-zA-Z]{2,}$";

    public boolean isValidFirstName(String firstName) {
        if (firstName == null)
            return false;
        return firstName.matches(FIRST_NAME_PATTERN);
    }
}