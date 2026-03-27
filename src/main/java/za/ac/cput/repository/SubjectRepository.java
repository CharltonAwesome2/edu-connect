package za.ac.cput.repository;

import za.ac.cput.domain.Subject;

import java.util.HashSet;
import java.util.Set;

public class SubjectRepository {

    private Set<Subject> subjectDB = new HashSet<>();

    public Subject create(Subject subject) {
        subjectDB.add(subject);
        return subject;
    }

    public Subject read(Long subjectId) {
        return subjectDB.stream()
                .filter(s -> s.getSubjectId().equals(subjectId))
                .findAny()
                .orElse(null);
    }

    public Subject update(Subject subject) {
        Subject oldSubject = read(subject.getSubjectId());
        if (oldSubject != null) {
            subjectDB.remove(oldSubject);
            subjectDB.add(subject);
            return subject;
        }
        return null;
    }

    public boolean delete(Long subjectId) {
        Subject subject = read(subjectId);
        if (subject != null) {
            subjectDB.remove(subject);
            return true;
        }
        return false;
    }

    public Set<Subject> getAll() {
        return subjectDB;
    }
}
