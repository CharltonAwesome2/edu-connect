package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.SessionStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TutoringSessionFactoryTest.java
 * TutoringSessionFactoryTest model class
 * Author: Esaile Franck Siani Djiakeng (220274142)
 * Date: 26 June 2026
 */


class TutoringSessionFactoryTest {

    private final User student = new User.Builder()
            .setUserId(1001L)
            .setName("Jane")
            .setSurname("Smith")
            .setStudentNumber("221000111")
            .setEmail("jane.smith@educonnect.com")
            .setContactNumber("0711111111")
            .build();

    private final TutorProfile tutorProfile = new TutorProfile.Builder()
            .setTutorProfileId(2002L)
            .setBio("Math tutor")
            .setYearsExperience(4)
            .setHourlyRate(150.0)
            .setAverageRating(0.0)
            .setUser(student)
            .build();

    private final Subject subject = new Subject.Builder()
            .setSubjectId(3003L)
            .setSubjectName("Mathematics")
            .setDepartment("Science")
            .build();

    @Test
    void createTutorSession() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(1);

        TutoringSession session = TutoringSessionFactory.createTutorSession(
                start,
                end,
                SessionStatus.SCHEDULED.name(),
                tutorProfile,
                student,
                subject,
                null,
                null
        );

        assertNotNull(session);
        assertNotNull(session.getSessionId());
        assertEquals(start, session.getSessionStart());
        assertEquals(end, session.getSessionEnd());
        assertEquals(SessionStatus.SCHEDULED.name(), session.getSessionStatus());
        assertEquals(tutorProfile, session.getTutor());
        assertEquals(student, session.getStudent());
        assertEquals(subject, session.getSubject());
        assertNotNull(session.getReviews());
        assertTrue(session.getReviews().isEmpty());
    }

    @Test
    void createTutorSessionWithNullTutorProfile() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(1);

        TutoringSession session = TutoringSessionFactory.createTutorSession(
                start,
                end,
                SessionStatus.SCHEDULED.name(),
                null,
                student,
                subject,
                null,
                null
        );

        assertNull(session);
    }

    @Test
    void createTutorSessionWithBlankStatus() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(1);

        TutoringSession session = TutoringSessionFactory.createTutorSession(
                start,
                end,
                "",
                tutorProfile,
                student,
                subject,
                null,
                null
        );

        assertNull(session);
    }
}