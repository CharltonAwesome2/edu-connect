package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.enums.SessionStatus;
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
    public static TutoringSession createTutorSession(TutorProfile tutorProfile, User student, Subject subject, LocalDateTime sessionStart, LocalDateTime sessionEnd) {
        Long sessionId = HelperUtil.generateId();

        //Validation
        if (tutorProfile == null) {
            throw new IllegalArgumentException("Tutor cannot be null");
        }
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        if (sessionStart == null || sessionEnd == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return new TutoringSession.Builder()
                .setSessionId(sessionId)
                .setTutor(tutorProfile)
                .setStudent(student)
                .setSubject(subject).
                setSessionStart(sessionStart)
                .setSessionEnd(sessionEnd)
                .build();

    }

}
