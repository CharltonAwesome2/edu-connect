package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;
import java.util.List;

/**
 * TutoringSession.java
 * TutorSession model class
 * Author: Esaile Franck Siani Djiakeng (220274142)
 * Date: 18 March 2026
 */

public class TutoringSessionFactory {
    //Declaration of the TutorSession Object
    public static TutoringSession createTutorSession(LocalDateTime sessionStart,
                                                     LocalDateTime sessionEnd,
                                                     String sessionStatus,
                                                     TutorProfile tutorProfile,
                                                     User student,
                                                     Subject subject,
                                                     Payment payment,
                                                     List<TutorReview> reviews) {
        Long sessionId = HelperUtil.generateId();

        //Validation
        if (HelperUtil.isInvalidInput(sessionStart,
                                    sessionEnd,
                                    sessionStatus,
                                    tutorProfile,
                                    student,
                                    subject)) {
            return null;
        }
        //Returning the new Tutoring Session Object after Validation
        return new TutoringSession.Builder()
                .setSessionId(sessionId)
                .setSessionStart(sessionStart)
                .setSessionEnd(sessionEnd)
                .setSessionStatus(sessionStatus)
                .setTutorProfile(tutorProfile)
                .setStudent(student)
                .setSubject(subject)
                .setPayment(payment)
                .setTutorReview(reviews != null ? reviews : List.of())
                .build();

    }
}
