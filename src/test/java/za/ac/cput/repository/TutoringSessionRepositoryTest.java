package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TutoringSessionRepositoryTest {

    private static ITutoringSessionRepository repository;
    private static TutoringSession session;

    private static TutorProfile tutorProfile;
    private static User student;
    private static Subject subject;

    @BeforeAll
    static void setUp() {
        repository = TutoringSessionRepository.getInstance();

        tutorProfile = TutorProfileFactory.createTutorProfile("Biology Tutor",
                2,
                350.0,
                4.5);
        student = new User.Builder()
                .setUserId(1L)
                .setName("Dean")
                .setSurname("Botha")
                .setEmail("DeanBotha@gmail.com")
                .build();

        subject = new Subject.Builder()
                .setSubjectId(2L)
                .setSubjectName("Biology")
                .build();

        session = TutoringSessionFactory.createTutorSession(tutorProfile,
                student,
                subject,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2));

    }

    @Test
    void create() {
        TutoringSession created = repository.create(session);
        assertNotNull(created);
    }

    @Test
    void read() {
        TutoringSession read = repository.read(session.getSessionId());
        assertNotNull(read);
    }

    @Test
    void update() {
        TutoringSession updated = new TutoringSession.Builder()
                .copy(session)
                .setSessionEnd(LocalDateTime.now().plusHours(2))
                .build();

        TutoringSession result = repository.update(updated);
        assertNotNull(result);
    }

    @Test
    void delete() {
        repository.delete(session.getSessionId());
        assertNull(repository.read(session.getSessionId()));
    }

    @Test
    void getAllTutoringSessionId() {
        TutorProfile tutorProfile = TutorProfileFactory.createTutorProfile("Math Tutor",
                3,
                200.0,
                4.2);

        User student = new User.Builder()
                .setUserId(1L)
                .setName("John")
                .build();

        Subject subject = new Subject.Builder()
                .setSubjectId(1L)
                .setSubjectName("Math")
                .build();

        TutoringSession session = TutoringSessionFactory.createTutorSession(
                tutorProfile,
                student,
                subject,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1)
        );

        repository.create(session);
        List<TutoringSession> sessions = repository.getAllTutoringSessionId();
        assertNotNull(sessions);
        assertFalse(sessions.isEmpty());

        System.out.println(sessions);
    }

    @Test
    void getTutoringSessionsByTutor() {
        TutorProfile tutor = TutorProfileFactory.createTutorProfile("Physics Tutor",
                4,
                250.0,
                4.0);

        User student = new User.Builder()
                .setUserId(2L)
                .setName("Alice")
                .build();
        Subject subject = new Subject.Builder()
                .setSubjectId(2L)
                .setSubjectName("Physics")
                .build();
        TutoringSession session = TutoringSessionFactory.createTutorSession(
                tutor, student, subject,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2)
        );

        repository.create(session);
        List<TutoringSession> sessions = repository.getTutoringSessionsByTutor(tutor);
        assertNotNull(sessions);
        assertFalse(sessions.isEmpty());

        System.out.println(sessions);

    }

    @Test
    void getTutoringSessionsByStudent() {
        TutorProfile tutor = TutorProfileFactory.createTutorProfile("Chemistry Tutor",
                5,
                300.0,
                4.8);

        User student = new User.Builder()
                .setUserId(3L)
                .setName("Bob")
                .build();

        Subject subject = new Subject.Builder()
                .setSubjectId(3L)
                .setSubjectName("Chemistry")
                .build();

        TutoringSession session = TutoringSessionFactory.createTutorSession(
                tutor, student, subject,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1)
        );
        repository.create(session);
        List<TutoringSession> sessions = repository.getTutoringSessionsByStudent(student);
        assertNotNull(sessions);
        assertFalse(sessions.isEmpty());
        System.out.println(sessions);
    }

    @Test
    void getTutoringSessionsBySubject() {
        TutorProfile tutor = TutorProfileFactory.createTutorProfile("Math Tutor",
                3,
                200.0,
                4.5);

        User student = new User.Builder()
                .setUserId(4L)
                .setName("Sam")
                .build();

        Subject subject = new Subject.Builder()
                .setSubjectId(10L)
                .setSubjectName("Mathematics")
                .build();

        TutoringSession session = TutoringSessionFactory.createTutorSession(
                tutor, student, subject,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1));
        repository.create(session);
        List<TutoringSession> sessions = repository.getTutoringSessionsBySubject(subject);
        assertNotNull(sessions);
        assertFalse(sessions.isEmpty());

        System.out.println(sessions);

    }

}