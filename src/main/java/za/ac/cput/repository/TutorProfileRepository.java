package za.ac.cput.repository;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.util.HelperUtil;

import java.util.ArrayList;
import java.util.List;

public class TutorProfileRepository implements ITutorProfileRepository {

    private static ITutorProfileRepository repository = null;

    public static ITutorProfileRepository getInstance() {
        if (repository == null) {
            repository = new TutorProfileRepository();
        }
        return repository;
    }

    public List<TutorProfile> allTutorProfile;

    private TutorProfileRepository() {
        allTutorProfile = new ArrayList<>();
    }

    @Override
    public TutorProfile create(TutorProfile tutorProfile) {
        allTutorProfile.add(tutorProfile);
        return tutorProfile;
    }

    @Override
    public TutorProfile read(Long tutorProfileId) {
        for (TutorProfile tutorProfile : allTutorProfile) {
            if (tutorProfile != null &&
                    tutorProfile.getTutorProfileId().equals(tutorProfileId)) {
                return tutorProfile;
            }
        }
        return null;
    }

    @Override
    public TutorProfile update(TutorProfile tutorProfile) {
        TutorProfile oldTutorProfile = read(tutorProfile.getTutorProfileId());
        if (oldTutorProfile != null) {
            allTutorProfile.remove(oldTutorProfile);
            allTutorProfile.add(tutorProfile);
            return tutorProfile;
        }
        return null;
    }

    @Override
    public boolean delete(Long tutorProfileId) {
        TutorProfile tutorProfile = read(tutorProfileId);
        if (tutorProfile != null) {
            allTutorProfile.remove(tutorProfile);
            return true;
        }
        return false;
    }

    @Override
    public List<TutorProfile> getAllTutorProfile() {
        return allTutorProfile;
    }

    @Override
    public List<TutorProfile> getTutorProfileByExperience(int yearsExperience) {
        if (HelperUtil.isValidYearsOfExperience(yearsExperience)) {
            return List.of();
        }
        List<TutorProfile> results = new ArrayList<>();
        for (TutorProfile tutorProfile : allTutorProfile) {
            if (tutorProfile.getYearsExperience() >= yearsExperience) {
                results.add(tutorProfile);
            }
        }
        return results;
    }

    @Override
    public List<TutorProfile> getTutorProfileByRating(double averageRating) {
        if (HelperUtil.isValidRating(averageRating)) {
            return List.of();
        }
        List<TutorProfile> results = new ArrayList<>();
        for (TutorProfile tutorProfile : allTutorProfile) {
            if (tutorProfile.getAverageRating() >= averageRating) {
                results.add(tutorProfile);
            }
        }
        return results;
    }

}
