package za.ac.cput.factory;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;
import java.util.List;

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
                                                  double rating) {
        return createTutorProfile(bio, yearsExperience, hourlyRate, rating, null, null, null);
    }

    public static TutorProfile createTutorProfile(String bio,
                                                  int yearsExperience,
                                                  double hourlyRate,
                                                  double rating,
                                                  User user,
                                                  List<TutorSubject> subjects,
                                                  List<TutoringSession> sessions){
        Long tutorProfileId = HelperUtil.generateId();
        //Validation
        if(HelperUtil.isNullOrEmpty(bio) ||
           !HelperUtil.isPositiveDouble(hourlyRate) ||
           !HelperUtil.isZeroOrPositiveInteger(yearsExperience) ||
           !HelperUtil.isValidRating(rating)){
            return null;
        }
        //Returning the new Tutoring Profile Object after Validation
        return new TutorProfile.Builder()
                .setTutorProfileId(tutorProfileId)
                .setBio(bio)
                .setYearsExperience(yearsExperience)
                .setHourlyRate(hourlyRate)
                .setAverageRating(rating)
                .setCreatedAt(LocalDateTime.now())
                .setUser(user)
                .build();
    }
}
