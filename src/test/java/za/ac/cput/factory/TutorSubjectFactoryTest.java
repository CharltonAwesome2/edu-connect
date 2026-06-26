package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.domain.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TutorSubjectFactoryTest.java
 * TutorSubjectFactoryTest model class
 * Author: Esaile Franck Siani Djiakeng (220274142)
 * Date: 26 June 2026
 */

class TutorSubjectFactoryTest {

    private final User user = new User.Builder()
            .setUserId(1L)
            .setName("John")
            .setSurname("Doe")
            .setStudentNumber("221234567")
            .setEmail("john.doe@educonnect.com")
            .setContactNumber("0712345678")
            .setCreatedAt(LocalDateTime.now())
            .build();

    private final TutorProfile tutorProfile = new TutorProfile.Builder()
            .setTutorProfileId(10L)
            .setBio("Java tutor")
            .setYearsExperience(3)
            .setHourlyRate(120.0)
            .setAverageRating(0.0)
            .setCreatedAt(LocalDateTime.now())
            .setUser(user)
            .build();

    private final Subject subject = new Subject.Builder()
            .setSubjectId(20L)
            .setSubjectName("Programming 1")
            .setDepartment("ICT")
            .build();

    @Test
    void createTutorSubject() {
        TutorSubject tutorSubject = TutorSubjectFactory.createTutorSubject(tutorProfile, subject);

        assertNotNull(tutorSubject);
        assertNotNull(tutorSubject.getTutorSubjectId());
        assertEquals(tutorProfile, tutorSubject.getTutorProfile());
        assertEquals(subject, tutorSubject.getSubject());
    }

    @Test
    void createTutorSubjectWithNullTutorProfile() {
        TutorSubject tutorSubject = TutorSubjectFactory.createTutorSubject(null, subject);

        assertNull(tutorSubject);
    }

    @Test
    void createTutorSubjectWithNullSubject() {
        TutorSubject tutorSubject = TutorSubjectFactory.createTutorSubject(tutorProfile, null);

        assertNull(tutorSubject);
    }
}