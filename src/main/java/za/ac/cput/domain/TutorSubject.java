package za.ac.cput.domain;

/**
 * TutorSubject.java
 * TutorSubject model class
 * Author: Esaile Franck Siani Djiakeng (220274142)
 * Date: 11 March 2026
 */

public class TutorSubject {

    // Private Attribute
    private Long tutorSubjectId;
    private TutorProfile tutorProfile;
    private Subject subject;

    //Empty Constructor
    private TutorSubject() {
    }

    //Builder Constructor will be here
    private TutorSubject(Builder build) {
        this.tutorSubjectId = build.tutorSubjectId;
        this.tutorProfile = build.tutorProfile;
        this.subject = build.subject;

    }

    // Getters
    public Long getTutorSubjectId() {
        return tutorSubjectId;
    }

    public TutorProfile getTutorProfile() {
        return tutorProfile;
    }

    public Subject getSubject() {
        return subject;
    }

    //toString methods for the Class
    @Override
    public String toString() {
        return "TutorSubject{" +
                "tutorSubjectId=" + tutorSubjectId +
                ", tutorProfile=" + tutorProfile +
                ", subject=" + subject +
                '}';
    }

    //Builder pattern and its setters
    public static class Builder {
        private Long tutorSubjectId;
        private TutorProfile tutorProfile;
        private Subject subject;

        public Builder setTutorSubjectId(Long tutorSubjectId) {
            this.tutorSubjectId = tutorSubjectId;
            return this;
        }

        public Builder setTutorProfile(TutorProfile tutorProfile) {
            this.tutorProfile = tutorProfile;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        //Add the deep copy method to facilitate its Repo;
        public Builder copy(TutorSubject tutorSubject) {
            this.tutorSubjectId = tutorSubject.tutorSubjectId;
            this.tutorProfile = tutorSubject.tutorProfile;
            this.subject = tutorSubject.subject;
            return this;
        }

        public TutorSubject build() {
            return new TutorSubject(this);
        }
    }
}
