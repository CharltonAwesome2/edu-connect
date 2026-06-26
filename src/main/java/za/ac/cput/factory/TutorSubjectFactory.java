package za.ac.cput.factory;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.util.HelperUtil;

/**
 * TutorSubject.java
 * TutorSubject model class
 * Author: Esaile Franck Siani Djiakeng (220274142)
 * Date: 18 March 2026
 */

public class TutorSubjectFactory {

    //Declaration of the TutorSubject Object
    public static TutorSubject createTutorSubject(TutorProfile tutorProfile,
            Subject subject) {
        //
        Long tutorSubjectId = HelperUtil.generateId();

        //Validation
        if (tutorProfile == null || subject == null) {
            return null;
        }
        //Returning the new Tutoring Subject Object after Validation
        return new TutorSubject.Builder()
                .setTutorSubjectId(tutorSubjectId)
                .setTutorProfile(tutorProfile)
                .setSubject(subject)
                .build();
    }
}
