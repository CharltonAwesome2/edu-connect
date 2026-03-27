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
    private SessionStatus sessionStatus;
    private TutorProfile tutor;
    private User student;
    private Subject subject;

    public TutoringSession() {
    }

    //Builder Constructor would be here;
    public TutoringSession(Builder build) {
        this.sessionId = build.sessionId;
        this.sessionStart = build.sessionStart;
        this.sessionEnd = build.sessionEnd;
        this.createdAt = build.createdAt;
        this.sessionStatus = build.sessionStatus;
        this.tutor = build.tutor;
        this.student = build.student;
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
        return sessionStatus;
    }

    public User getStudent() {
        return student;
    }

    public TutorProfile getTutor() {
        return tutor;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "TutoringSession [sessionId=" + sessionId + ", sessionStart=" + sessionStart + ", sessionEnd="
                + sessionEnd + ", createdAt=" + createdAt + ", status=" + sessionStatus + ", tutor=" + tutor + ", student="
                + student + ", subject=" + subject + "]";
    }

    public static class Builder {

        private Long sessionId;
        private LocalDateTime sessionStart;
        private LocalDateTime sessionEnd;
        private LocalDateTime createdAt;
        private SessionStatus sessionStatus;
        private TutorProfile tutor;
        private User student;
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

        public Builder setSessionStatus(SessionStatus sessionStatus) {
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
            this.tutor = session.tutor;
            this.sessionStatus = session.sessionStatus;
            this.student = session.student;
            this.subject = session.subject;
            return this;
        }

        public TutoringSession build() {
            return new TutoringSession(this);
        }
    }

}
