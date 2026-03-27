package za.ac.cput.repository;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;

import java.util.ArrayList;
import java.util.List;

public class TutoringSessionRepository implements ITutoringSessionRepository {

    public List<TutoringSession> allTutoringSession;

    public TutoringSessionRepository() {
        allTutoringSession = new ArrayList<>();
    }

    public static ITutoringSessionRepository repository = null;

    public static ITutoringSessionRepository getInstance() {
        if (repository == null) {
            repository = new TutoringSessionRepository();
        }
        return repository;
    }

    @Override
    public TutoringSession create(TutoringSession session) {
        allTutoringSession.add(session);
        return session;
    }

    @Override
    public TutoringSession read(Long sessionId) {
        for (TutoringSession tutoringSession : allTutoringSession) {
            if (tutoringSession.getSessionId().equals(sessionId)) {
                return tutoringSession;
            }
        }
        return null;
    }

    @Override
    public TutoringSession update(TutoringSession session) {
        TutoringSession oldSession = read(session.getSessionId());
        if (oldSession != null) {
            allTutoringSession.remove(oldSession);
            allTutoringSession.add(session);
            return session;
        }
        return null;
    }

    @Override
    public boolean delete(Long sessionId) {
        TutoringSession tutoringSession = read(sessionId);
        if (tutoringSession != null) {
            allTutoringSession.remove(tutoringSession);
            return true;
        }
        return false;
    }

    @Override
    public List<TutoringSession> getAllTutoringSessionId() {
        return allTutoringSession;
    }

    @Override
    public List<TutoringSession> getTutoringSessionsByTutor(TutorProfile tutorProfile) {
        if (tutorProfile == null) {
            return List.of();
        }

        List<TutoringSession> result = new ArrayList<>();
        for (TutoringSession tutoringSession : allTutoringSession) {
            if (tutoringSession.getTutor().equals(tutorProfile.getTutorProfileId())) ;
            result.add(tutoringSession);
        }
        return result;
    }

    @Override
    public List<TutoringSession> getTutoringSessionsByStudent(User student) {
        if (student == null) {
            return List.of();
        }
        List<TutoringSession> result = new ArrayList<>();
        for (TutoringSession tutoringSession : allTutoringSession) {
            if (tutoringSession.getStudent().equals(student.getStudentNumber())) ;
            result.add(tutoringSession);
        }
        return result;
    }

    @Override
    public List<TutoringSession> getTutoringSessionsBySubject(Subject subject) {
        if (subject == null) {
            return List.of();
        }
        List<TutoringSession> result = new ArrayList<>();
        for (TutoringSession tutoringSession : allTutoringSession) {
            if (tutoringSession.getSubject().equals(subject.getSubjectId())) ;
            result.add(tutoringSession);
        }
        return result;
    }
}
