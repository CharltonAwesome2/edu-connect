package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.factory.TutorProfileFactory;
import za.ac.cput.factory.TutorSubjectFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TutorSubjectRepositoryTest {

    private static ITutorSubjectRepository repository;
    private static TutorSubject tutorSubject;
    private static TutorProfile tutor;
    private static Subject subject;

    @BeforeAll
    static void setUp() {
        repository = TutorSubjectRepository.getInstance();

        tutor = TutorProfileFactory.createTutorProfile("Math Tutor",
                3,
                200.0,
                4.0);
        subject = new Subject.Builder()
                .setSubjectId(1L)
                .setSubjectName("Mathematics")
                .build();
        tutorSubject = TutorSubjectFactory.createTutorSubject(tutor, subject);
    }

    @Test
    @Order(1)
    void create() {
        TutorSubject created = repository.create(tutorSubject);
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        TutorSubject read = repository.read(tutorSubject.getTutorSubjectId());
        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {
        TutorSubject updated = new TutorSubject.Builder()
                .copy(tutorSubject)
                .build();

        TutorSubject result = repository.update(updated);
        assertNotNull(result);
    }

    @Test
    @Order(4)
    void delete() {
        repository.delete(tutorSubject.getTutorSubjectId());
        assertNull(repository.read(tutorSubject.getTutorSubjectId()));
    }

    @Test
    @Order(5)
    void getTutorBySubjectId() {

        Subject subject = new Subject.Builder()
                .setSubjectId(1L)
                .setSubjectName("Mathematics")
                .build();

        TutorProfile tutorProfile1 = TutorProfileFactory.createTutorProfile("Arnold Maths Tutor",
                3,
                200.0,
                4.5);
        TutorProfile tutorProfile2 = TutorProfileFactory.createTutorProfile("Brian Physical Science Tutor",
                7,
                450.0,
                4.8);
        repository.create(TutorSubjectFactory.createTutorSubject(tutorProfile1, subject));
        repository.create(TutorSubjectFactory.createTutorSubject(tutorProfile2, subject));

        List<TutorSubject> tutor = repository.getTutorBySubjectId(subject.getSubjectId());
        assertNotNull(tutor);
        assertFalse(tutor.isEmpty());
        System.out.println(tutor);
    }

    @Test
    @Order(6)
    void getTutorBySubject() {
        Subject subject = new Subject.Builder()
                .setSubjectId(1L)
                .setSubjectName("English")
                .build();

        TutorProfile tutor1 = TutorProfileFactory.createTutorProfile("Alex EGD Tutor",
                3,
                200.0,
                3.8);
        TutorProfile tutor2 = TutorProfileFactory.createTutorProfile("Bastian English Tutor",
                5,
                300.0,
                4.0);

        repository.create(TutorSubjectFactory.createTutorSubject(tutor1, subject));
        repository.create(TutorSubjectFactory.createTutorSubject(tutor2, subject));
        List<TutorSubject> tutors = repository.getTutorBySubject(subject);
        assertNotNull(tutors);
        assertFalse(tutors.isEmpty());

        System.out.println(tutors);

    }

    @Test
    @Order(7)
    void getTutorSubjectsByTutorProfile() {
        TutorProfile tutor = TutorProfileFactory.createTutorProfile("Chris",
                5,
                300.0,
                3.8);

        Subject subject1 = new Subject.Builder()
                .setSubjectId(3L)
                .setSubjectName("Chemistry")
                .build();

        Subject subject2 = new Subject.Builder()
                .setSubjectId(4L)
                .setSubjectName("Biology")
                .build();

        repository.create(TutorSubjectFactory.createTutorSubject(tutor, subject1));
        repository.create(TutorSubjectFactory.createTutorSubject(tutor, subject2));
        List<TutorSubject> results = repository.getTutorSubjectsByTutorProfile(tutor);
        assertNotNull(results);
        assertFalse(results.isEmpty());

        System.out.println(results);

    }
}