package za.ac.cput.domain;

import java.time.LocalDateTime;

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
    private double averageRating;
    private LocalDateTime createdAt;
    private User user;

    public TutorProfile() {
    }

    //Builder Constructor
    private TutorProfile(Builder build) {
        this.tutorProfileId = build.tutorProfileId;
        this.bio = build.bio;
        this.yearsExperience = build.yearsExperience;
        this.hourlyRate = build.hourlyRate;
        this.createdAt = build.createdAt;
        this.averageRating = build.averageRating;
        this.user = build.user;
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

    public double getAverageRating() {
        return averageRating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "TutorProfile{" +
                "tutorProfileId=" + tutorProfileId +
                ", bio='" + bio + '\'' +
                ", yearsExperience=" + yearsExperience +
                ", hourlyRate=" + hourlyRate +
                ", averageRating=" + averageRating +
                ", createdAt=" + createdAt +
                ", rating=" + user +
                '}';
    }

    public static class Builder {
        private Long tutorProfileId;
        private String bio;
        private int yearsExperience;
        private double hourlyRate;
        private double averageRating;
        private LocalDateTime createdAt;
        private User user;

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

        public Builder setAverageRating(double averageRating) {
            this.averageRating = averageRating;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(TutorProfile tutorProfile) {
            this.tutorProfileId = tutorProfile.tutorProfileId;
            this.bio = tutorProfile.bio;
            this.yearsExperience = tutorProfile.yearsExperience;
            this.hourlyRate = tutorProfile.hourlyRate;
            this.averageRating = tutorProfile.averageRating;
            this.createdAt = tutorProfile.createdAt;
            this.user = tutorProfile.user;
            return this;
        }

        public TutorProfile build() {
            if (yearsExperience < 0)
                throw new IllegalArgumentException(("Years of Experiment cannot be negative"));
            if (hourlyRate < 0)
                throw new IllegalArgumentException("Hourly Rate cannot negative");
            if (averageRating < 0 || averageRating > 0)
                throw new IllegalArgumentException(("Rating must be between 0 and 5"));
            return new TutorProfile(this);
        }

    }
}
