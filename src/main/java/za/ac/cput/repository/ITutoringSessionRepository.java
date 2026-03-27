package za.ac.cput.repository;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;

import java.util.List;

public interface ITutoringSessionRepository extends IRepository<TutoringSession, Long>{
    List<TutoringSession>getAllTutoringSessionId();
    List<TutoringSession> getTutoringSessionsByTutor(TutorProfile tutorProfile);
    List<TutoringSession>getTutoringSessionsByStudent(User student);
    List<TutoringSession> getTutoringSessionsBySubject(Subject subject);

}
