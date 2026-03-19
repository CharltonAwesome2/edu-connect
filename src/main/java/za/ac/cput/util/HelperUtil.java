package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class HelperUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static boolean isNullOrEmpty(String inputString) {
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

    public static boolean isInvalidInput(LocalDateTime sessionStart,
                                       LocalDateTime sessionEnd,
                                       String sessionStatus,
                                       TutorProfile tutorProfile,
                                       User student,
                                       Subject subject){
        return sessionStart == null ||
               sessionEnd == null ||
               HelperUtil.isNullOrEmpty(sessionStatus) ||
               tutorProfile == null ||
               student == null ||
               subject == null ||
               sessionEnd.isBefore(sessionStart);

    }

    public static boolean isInvalidTutorSubject(TutorProfile tutorProfile,
                                                Subject subject){
        return   tutorProfile == null ||
                subject == null;
    }
    public static boolean isValidHourlyRate(double hourlyRate){
        return hourlyRate > 0;
    }
    public  static boolean isValidYearsOfExperience(int yearsExperience){
        return yearsExperience >= 0;
    }
    public static boolean isValidUser(User user){
        return user != null;
    }
    public static boolean isValidRating(double rating){
        return rating >= 0 & rating <= 5;
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
