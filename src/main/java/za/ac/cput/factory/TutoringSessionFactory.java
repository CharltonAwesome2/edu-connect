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
            TutorProfile tutor,
            User student,
            Subject subject) {
        Long sessionId = HelperUtil.generateId();

        //Validation
        if (sessionStatus == null ||
                tutor == null ||
                student == null ||
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
                .setTutor(tutor)
                .setStudent(student)
                .setSubject(subject)
                .build();

    }
}
