/*
 * UserMobileValidatorUC4 handles mobile number validation logic for user registration.
 * Mobile format: country code followed by space and 10 digit number e.g. 91 9919819801.
 * Part of BridgeLabz User Registration system - UC4.
 */
public class UserMobileValidatorUC4 {

    // Regex: 2 digit country code, space, then exactly 10 digits
    private static final String MOBILE_PATTERN = "^[0-9]{2} [0-9]{10}$";

    public boolean isValidMobile(String mobile) {
        if (mobile == null) return false;
        return mobile.matches(MOBILE_PATTERN);
    }
}