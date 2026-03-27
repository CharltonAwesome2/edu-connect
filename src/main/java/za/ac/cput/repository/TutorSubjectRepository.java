package za.ac.cput.repository;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.util.HelperUtil;

import java.util.ArrayList;
import java.util.List;

public class TutorSubjectRepository implements ITutorSubjectRepository {

    public List<TutorSubject> allTutorSubject;

    public TutorSubjectRepository() {
        allTutorSubject = new ArrayList<>();
    }

    public static ITutorSubjectRepository repository = null;

    public static ITutorSubjectRepository getInstance() {
        if (repository == null) {
            repository = new TutorSubjectRepository();
        }
        return repository;
    }

    @Override
    public TutorSubject create(TutorSubject tutorSubject) {
        allTutorSubject.add(tutorSubject);
        return tutorSubject;
    }

    @Override
    public TutorSubject read(Long tutorSubjectId) {
        for (TutorSubject tutorSubject : allTutorSubject) {
            if (tutorSubject != null &&
                    tutorSubject.getTutorSubjectId().equals(tutorSubjectId)) {
                return tutorSubject;
            }
        }
        return null;
    }

    @Override
    public TutorSubject update(TutorSubject tutorSubject) {
        TutorSubject oldTutorSubject = read(tutorSubject.getTutorSubjectId());
        if (oldTutorSubject != null) {
            allTutorSubject.remove(oldTutorSubject);
            allTutorSubject.add(tutorSubject);
            return tutorSubject;
        }
        return null;
    }

    @Override
    public boolean delete(Long tutorSubjectId) {
        TutorSubject tutorSubject = read(tutorSubjectId);
        if (tutorSubject != null) {
            allTutorSubject.remove(tutorSubject);
            return true;
        }
        return false;
    }

    @Override
    public List<TutorSubject> getTutorBySubjectId(Long tutorSubjectId) {
        if (tutorSubjectId == null) {
            return List.of();
        }
        List<TutorSubject> results = new ArrayList<>();
        for (TutorSubject tutorSubject : allTutorSubject) {
            if (tutorSubjectId.equals(tutorSubject.getTutorSubjectId())) {
                results.add(tutorSubject);
            }
        }
        return results;
    }

    @Override
    public List<TutorSubject> getTutorBySubject(Subject subject) {
        if (subject == null) {
            return List.of();
        }
        List<TutorSubject> results = new ArrayList<>();
        for (TutorSubject tutorSubject : allTutorSubject) {
            if (tutorSubject.getSubject().equals(subject)) {
                results.add(tutorSubject);
            }
        }
        return results;
    }

    @Override
    public List<TutorSubject> getTutorSubjectsByTutorProfile(TutorProfile tutorProfile) {
        if (tutorProfile == null) {
            return List.of();
        }
        List<TutorSubject> results = new ArrayList<>();
        for (TutorSubject tutorSubject : allTutorSubject) {
            if (tutorSubject.getTutorProfile().equals(tutorProfile.getTutorProfileId())) {
                results.add(tutorSubject);
            }
        }
        return results;
    }
}
