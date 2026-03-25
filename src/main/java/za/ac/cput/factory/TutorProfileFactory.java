package za.ac.cput.factory;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

/**
 * TutorProfile.java
 * TutorProfile model class
 * Author: Esaile Franck Siani Djiakeng (220274142)
 * Date: 18 March 2026
 */

public class TutorProfileFactory {
    //Declaration of the TutorProfile Object
    public static TutorProfile createTutorProfile(String bio,
            int yearsExperience,
            double hourlyRate,
            double averageRating,
            LocalDateTime createdAt,
            User user) {
        Long tutorProfileId = HelperUtil.generateId();
        //Validation
        if (HelperUtil.isNullOrEmpty(bio) ||
                !HelperUtil.isZeroOrPositiveInteger(yearsExperience) ||
                !HelperUtil.isPositiveDouble(hourlyRate) ||
                !HelperUtil.isValidRating(averageRating)
                || user == null) {
            // LocalDateTime does not need to be validated
            return null;
        }
        //Returning the new Tutoring Profile Object after Validation
        return new TutorProfile.Builder()
                .setTutorProfileId(tutorProfileId)
                .setBio(bio)
                .setYearsExperience(yearsExperience)
                .setHourlyRate(hourlyRate)
                .setAverageRating(averageRating)
                .setCreatedAt(createdAt)
                .setUser(user)
                .build();
    }
}
