package za.ac.cput.repository;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;

import java.util.List;

public interface ITutorSubjectRepository extends IRepository<TutorSubject, Long>{

    List<TutorSubject>getTutorBySubjectId(Long tutorSubjectId);
    List<TutorSubject>getTutorSubjectsByTutorProfile(TutorProfile tutorProfile);
    List<TutorSubject>getTutorBySubject(Subject subject);

}
