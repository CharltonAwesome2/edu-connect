package za.ac.cput.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Esaile Siani
 * Djiakeng Franck
 * 220274142
 */

public class TutoringSession {

    private Long sessionId;
    private LocalDateTime sessionStart;
    private LocalDateTime sessionEnd;
    private String sessionStatus;
    private TutorProfile tutor;
    private User student;
    private Payment payment;
    private List<TutorReview> reviews;

    private TutoringSession() {
    }

    //Builder Constructor would be here;
    public TutoringSession(Builder build) {
        TutoringSession session = new TutoringSession();
        session.sessionId = build.sessionId;
        session.sessionStart = build.sessionStart;
        session.sessionEnd = build.sessionEnd;
        session.sessionStatus = build.sessionStatus;
        session.tutor = build.tutor;
        session.student = build.student;
        session.payment = build.payment;
        session.reviews = build.reviews;
    }


    public Long getSessionId() {
        return sessionId;
    }

    public LocalDateTime getSessionStart() {
        return sessionStart;
    }

    public LocalDateTime getSessionEnd() {
        return sessionEnd;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public User getStudent() {
        return student;
    }

    public TutorProfile getTutor() {
        return tutor;
    }

    public Payment getPayment() {
        return payment;
    }

    public List<TutorReview> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "TutoringSession{" +
                "sessionId=" + sessionId +
                ", sessionStart=" + sessionStart +
                ", sessionEnd=" + sessionEnd +
                ", sessionStatus='" + sessionStatus + '\'' +
                ", tutor=" + tutor +
                ", student=" + student +
                ", payment=" + payment +
                ", reviews=" + reviews +
                '}';
    }

    public static class Builder {

        private Long sessionId;
        private LocalDateTime sessionStart;
        private LocalDateTime sessionEnd;
        private String sessionStatus;
        private TutorProfile tutor;
        private User student;
        private Payment payment;
        private List<TutorReview> reviews;

        public Builder setSessionId(Long sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder setSessionStart(LocalDateTime sessionStart) {
            this.sessionStart = sessionStart;
            return this;
        }

        public Builder setSessionEnd(LocalDateTime sessionEnd) {
            this.sessionEnd = sessionEnd;
            return this;
        }

        public Builder setSessionStatus(String sessionStatus) {
            this.sessionStatus = sessionStatus;
            return this;
        }

        public Builder setTutor(TutorProfile tutor) {
            this.tutor = tutor;
            return this;
        }

        public Builder setStudent(User student) {
            this.student = student;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder setTutorReview(List<TutorReview> reviews) {
            this.reviews = reviews;
            return this;
        }

        public Builder copy(TutoringSession session) {
            this.sessionId = session.sessionId;
            this.sessionStart = session.sessionStart;
            this.sessionEnd = session.sessionEnd;
            this.sessionStatus = session.sessionStatus;
            this.tutor = session.tutor;
            this.student = session.student;
            this.payment = session.payment;
            this.reviews = session.reviews;
            return this;
        }

        public TutoringSession build() {
            return new TutoringSession(this);
        }
    }


}
