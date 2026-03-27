package za.ac.cput.repository;

import za.ac.cput.domain.TutorProfile;

import java.util.List;

public interface ITutorProfileRepository extends IRepository<TutorProfile, Long>{

    List<TutorProfile>getAllTutorProfile();
    List<TutorProfile>getTutorProfileByExperience(int yearsExperience);
    List<TutorProfile>getTutorProfileByRating(double averageRating);

}
