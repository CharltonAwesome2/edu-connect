package za.ac.cput.domain;

import java.time.LocalDateTime;

import za.ac.cput.enums.SessionStatus;

/**
 * TutoringSession.java
 * TutoringSession model class
 * Author: Esaile Franck Siani Djiakeng (220274142)
 * Date: 11 March 2026
 */

public class TutoringSession {

    private Long sessionId;
    private LocalDateTime sessionStart;
    private LocalDateTime sessionEnd;
    private LocalDateTime createdAt;
    private SessionStatus status;
    private TutorProfile tutorProfile;
    private User user;
    private Subject subject;

    public TutoringSession() {
    }

    //Builder Constructor would be here;
    public TutoringSession(Builder build) {
        this.sessionId = build.sessionId;
        this.sessionStart = build.sessionStart;
        this.sessionEnd = build.sessionEnd;
        this.createdAt = build.createdAt;
        this.status = build.status;
        this.tutorProfile = build.tutorProfile;
        this.user = build.user;
        this.subject = build.subject;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public TutorProfile getTutorProfile() {
        return tutorProfile;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "TutoringSession [sessionId=" + sessionId + ", sessionStart=" + sessionStart + ", sessionEnd="
                + sessionEnd + ", createdAt=" + createdAt + ", status=" + status + ", tutorProfile=" + tutorProfile + ", user="
                + user + ", subject=" + subject + "]";
    }

    public static class Builder {

        private Long sessionId;
        private LocalDateTime sessionStart;
        private LocalDateTime sessionEnd;
        private LocalDateTime createdAt;
        private SessionStatus status;
        private TutorProfile tutorProfile;
        private User user;
        private Subject subject;

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

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setSessionStatus(SessionStatus status) {
            this.status = status;
            return this;
        }

        public Builder setTutorProfile(TutorProfile tutor) {
            this.tutorProfile = tutor;
            return this;
        }

        public Builder setUser(User tutorProfile) {
            this.user = tutorProfile;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        // public Builder setPayment(Payment payment) {
        //     this.payment = payment;
        //     return this;
        // }

        public Builder copy(TutoringSession session) {
            this.sessionId = session.sessionId;
            this.sessionStart = session.sessionStart;
            this.sessionEnd = session.sessionEnd;
            this.createdAt = session.createdAt;
            this.tutorProfile = session.tutorProfile;
            this.status = session.status;
            this.user = session.user;
            this.subject = session.subject;
            return this;
        }

        public TutoringSession build() {
            return new TutoringSession(this);
        }
    }

}
