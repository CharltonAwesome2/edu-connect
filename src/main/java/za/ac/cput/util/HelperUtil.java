package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

public class HelperUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static boolean isNullorEmpty(String inputString) {
        return inputString != null && !inputString.isEmpty();
    }

    public static boolean isValidEmail(String inputEmail) {
        EmailValidator emailValidator = EmailValidator.getInstance();

        return emailValidator.isValid(inputEmail);
    }

    public static Long generateId() {
        // return UUID.randomUUID();
        return Math.abs(UUID.randomUUID().getMostSignificantBits());
    }

    public static String hashPassword(String password) {
        return encoder.encode(password);
    }

    public static boolean verifyPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }

    public static String extractSalt(String hash) {
        return hash.substring(7, 29);
    }

    /*
    Valid:
    rating
    date
    status?
    money amount?
    time?
    */

    // ENUM status?
}
