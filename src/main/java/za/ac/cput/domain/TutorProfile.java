package za.ac.cput.domain;

import java.util.List;
import java.util.ArrayList;

/**
 * TutorProfile.java
 * TutorProfile model class
 * Author: Esaile Franck Siani Djiakeng (220274142)
 * Date: 11 March 2026
 */


public class TutorProfile {

    private Long tutorProfileId;
    private String bio;
    private int yearsExperience;
    private double hourlyRate;
    private double rating;
    private User user;
    private List<TutorSubject> subjects;
    private List<TutoringSession> sessions;

    private TutorProfile() {
    }

    //Builder Constructor
    private TutorProfile(Builder build) {
        this.tutorProfileId = build.tutorProfileId;
        this.bio = build.bio;
        this.yearsExperience = build.yearsExperience;
        this.hourlyRate = build.hourlyRate;
        this.rating = build.rating;
        this.user = build.user;
        this.subjects = build.subjects != null ? new ArrayList<>(build.subjects) : new ArrayList<>();
        this.sessions = build.sessions != null ? new ArrayList<>(build.sessions) : new ArrayList<>();
    }

    public void updateBio(){

    }

    public void updateRate(){
        
    }

    public Long getTutorProfileId() {
        return tutorProfileId;
    }

    public String getBio() {
        return bio;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getRating() {
        return rating;
    }

    public User getUser() {
        return user;
    }

    public List<TutorSubject> getSubjects() {
        return subjects;
    }

    public List<TutoringSession> getSessions() {
        return sessions;
    }

    @Override
    public String toString() {
        return "TutorProfile{" +
                "tutorProfileId=" + tutorProfileId +
                ", bio='" + bio + '\'' +
                ", yearsExperience=" + yearsExperience +
                ", hourlyRate=" + hourlyRate +
                ", rating=" + rating +
                ", rating=" + user +
                ", rating=" + subjects +
                ", rating=" + sessions +
                '}';
    }

    public static class Builder {
        private Long tutorProfileId;
        private String bio;
        private int yearsExperience;
        private double hourlyRate;
        private double rating;
        private User user;
        private List<TutorSubject> subjects;
        private List<TutoringSession> sessions;

        public Builder setTutorProfileId(Long tutorProfileId) {
            this.tutorProfileId = tutorProfileId;
            return this;
        }

        public Builder setBio(String bio) {
            this.bio = bio;
            return this;
        }

        public Builder setYearsExperience(int yearsExperience) {
            this.yearsExperience = yearsExperience;
            return this;
        }

        public Builder setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder setUser(User user){
            this.user = user;
            return this;
        }

        public Builder setSubjects(List<TutorSubject> subjects){
            this.subjects = subjects;
            return this;
        }

        public Builder setSessions(List<TutoringSession> sessions){
            this.sessions = sessions;
            return this;
        }

        public Builder copy(TutorProfile tutorProfile) {
            this.tutorProfileId = tutorProfile.tutorProfileId;
            this.bio = tutorProfile.bio;
            this.yearsExperience = tutorProfile.yearsExperience;
            this.hourlyRate = tutorProfile.hourlyRate;
            this.rating = tutorProfile.rating;
            this.user = tutorProfile.user;
            this.subjects = tutorProfile.subjects != null ? new ArrayList<>(tutorProfile.subjects) : new ArrayList<>();
            this.sessions = tutorProfile.sessions != null ? new ArrayList<>(tutorProfile.sessions) : new ArrayList<>();
            return this;
        }

        public TutorProfile build() {
            if (yearsExperience < 0)
                throw new IllegalArgumentException(("Years of Experiment cannot be negative"));
            if (hourlyRate < 0)
                throw new IllegalArgumentException("Hourly Rate cannot negative");
            if (rating < 0 || rating > 0)
                throw new IllegalArgumentException(("Rating must be between 0 and 5"));
            return new TutorProfile(this);
        }

    }
}
