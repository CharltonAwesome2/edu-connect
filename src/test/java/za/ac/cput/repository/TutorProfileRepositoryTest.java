package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.factory.TutorProfileFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TutorProfileRepositoryTest {

    private static ITutorProfileRepository repository;
    private static TutorProfile tutorProfile;

    @Test
    @Order(1)
    void create() {
        TutorProfile created = repository.create(tutorProfile);
        assertNotNull(created);
        assertEquals(tutorProfile.getTutorProfileId(), created.getTutorProfileId());
    }

    @Test
    @Order(2)
    void read() {
        TutorProfile read = repository.read(tutorProfile.getTutorProfileId());
        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {
        TutorProfile updated = new TutorProfile.Builder()
                .copy(tutorProfile)
                .setHourlyRate(300.0)
                .build();

        TutorProfile result = repository.update(updated);
        assertEquals(300.0, result.getHourlyRate());
    }

    @Test
    @Order(4)
    void delete() {
        repository.delete(tutorProfile.getTutorProfileId());
        TutorProfile deleted = repository.read(tutorProfile.getTutorProfileId());
        assertNull(deleted);
    }

    @Test
    @Order(5)
    void getAllTutorProfile() {
        TutorProfile tutor1 = TutorProfileFactory.createTutorProfile("Math Tutor",
                3,
                200.0,
                4.1);
        TutorProfile tutor2 = TutorProfileFactory.createTutorProfile("Science Tutor",
                4,
                250.0,
                3.2);

        repository.create(tutor1);
        repository.create(tutor2);
        List<TutorProfile> tutors = repository.getAllTutorProfile();
        assertNotNull(tutors);
        assertFalse(tutors.isEmpty());
        System.out.println(tutors);
    }

    @Test
    @Order(6)
    void getTutorProfileByExperience() {
        TutorProfile tutor = TutorProfileFactory.createTutorProfile("Physics Tutor",
                5,
                300.0,
                4.7);
        repository.create(tutor);
        List<TutorProfile> tutors = repository.getTutorProfileByExperience(5);
        assertNotNull(tutors);
        assertFalse(tutors.isEmpty());
        System.out.println(tutors);
    }

    @Test
    @Order(7)
    void getTutorProfileByRating() {
        TutorProfile tutor1 = TutorProfileFactory.createTutorProfile("Math Tutor",
                3,
                200.0,
                4.1);
        TutorProfile tutor2 = TutorProfileFactory.createTutorProfile("Science Tutor",
                4,
                250.0,
                3.2);
        repository.create(tutor1);
        repository.create(tutor2);
        List<TutorProfile> tutors = repository.getTutorProfileByRating(3.2);
        assertNotNull(tutors);
        assertFalse(tutors.isEmpty());
        System.out.println(tutors);
    }
}