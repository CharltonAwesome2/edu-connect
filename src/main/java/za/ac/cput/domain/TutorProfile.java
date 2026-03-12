package za.ac.cput.domain;

/**
 * Esaile Siani
 * Djiakeng Franck
 * 220274142
 */

public class TutorProfile {

    private Long tutorProfileId;
    private String bio;
    private int yearsExperience;
    private double hourlyRate;
    private double rating;

    private TutorProfile() {
    }

    //Builder Constructor
    private TutorProfile(Builder build) {
        this.tutorProfileId = build.tutorProfileId;
        this.bio = build.bio;
        this.yearsExperience = build.yearsExperience;
        this.hourlyRate = build.hourlyRate;
        this.rating = build.rating;

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

    @Override
    public String toString() {
        return "TutorProfile{" + "tutorProfileId=" + tutorProfileId + ", bio='" + bio + '\'' + ", yearsExperience=" + yearsExperience + ", hourlyRate=" + hourlyRate + ", rating=" + rating + '}';
    }

    public static class Builder {
        private Long tutorProfileId;
        private String bio;
        private int yearsExperience;
        private double hourlyRate;
        private double rating;

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

        public Builder copy(TutorProfile tutorProfile) {
            this.tutorProfileId = tutorProfile.tutorProfileId;
            this.bio = tutorProfile.bio;
            this.yearsExperience = tutorProfile.yearsExperience;
            this.hourlyRate = tutorProfile.hourlyRate;
            this.rating = tutorProfile.rating;
            return this;
        }

        public TutorProfile build() {
            if (yearsExperience < 0) throw new IllegalArgumentException(("Years of Experiment cannot be negative"));
            if (hourlyRate < 0) throw new IllegalArgumentException("Hourly Rate cannot negative");
            if (rating < 0 || rating > 0) throw new IllegalArgumentException(("Rating must be between 0 and 5"));
            return new TutorProfile(this);
        }

    }
}
