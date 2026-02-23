/*
 * UserEmailValidatorUC3 handles email validation logic for user registration.
 * Email format: abc.xyz@bl.co.in where abc, bl, co are mandatory and xyz, in are optional.
 * Part of BridgeLabz User Registration system - UC3.
 */
public class UserEmailValidatorUC3 {

    // Regex: mandatory local part @ mandatory domain, with optional subdomain parts
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9]+([.][a-zA-Z0-9]+)?@[a-zA-Z0-9]+[.][a-zA-Z0-9]{2,}([.][a-zA-Z]{2,})?$";

    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.matches(EMAIL_PATTERN);
    }
}