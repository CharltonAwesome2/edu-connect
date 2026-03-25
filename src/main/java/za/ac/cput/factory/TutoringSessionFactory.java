package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.enums.SessionStatus;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

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
            LocalDateTime createdAt,
            SessionStatus sessionStatus,
            TutorProfile tutorProfile,
            User user,
            Subject subject) {
        Long sessionId = HelperUtil.generateId();

        //Validation
        if (sessionStatus == null ||
                tutorProfile == null ||
                user == null ||
                subject == null

        ) {

            return null;
        }
        //Returning the new Tutoring Session Object after Validation
        return new TutoringSession.Builder()
                .setSessionId(sessionId)
                .setSessionStart(sessionStart)
                .setSessionEnd(sessionEnd)
                .setCreatedAt(createdAt)
                .setSessionStatus(sessionStatus)
                .setTutorProfile(tutorProfile)
                .setUser(user)
                .setSubject(subject)
                .build();

    }
}
