package za.ac.cput.domain;

// BookingRequest.java
//Booking Request model class
//Author:Reotshepile Stock (230875807)
//Date:17 March 2026

import java.time.LocalDate;

public class BookingRequest {

    private Long tutoringSessionId;
    private LocalDate requestedDate;
    private String status;
    private User student;
    private TutorProfile tutorProfile;
    private Subject subject;

    private BookingRequest(Builder builder) {
        this.tutoringSessionId = builder.tutoringSessionId;
        this.requestedDate = builder.requestedDate;
        this.status = builder.status;
        this.student = builder.student;
        this.tutorProfile = builder.tutorProfile;
        this.subject = builder.subject;
    }

    public void approveRequest(){

    }

    public void rejectRequest(){
        
    }

    public Long getTutoringSessionId() {
        return tutoringSessionId;
    }

    public LocalDate getRequestedDate() {
        return requestedDate;
    }

    public String getStatus() {
        return status;
    }

    public User getStudent() {
        return student;
    }

    public TutorProfile getTutorProfile() {
        return tutorProfile;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "tutoringSessionId=" + tutoringSessionId +
                ", date=" + requestedDate +
                ", status=" + status +
                ", student=" + student +
                ", tutorProfile=" + tutorProfile +
                ", subject=" + subject +
                '}';
    }

    public static class Builder {

        private Long tutoringSessionId;
        private LocalDate requestedDate;
        private String status;
        private User student;
        private TutorProfile tutorProfile;
        private Subject subject;

        public Builder setTutoringSessionId(Long tutoringSessionId) {
            this.tutoringSessionId = tutoringSessionId;
            return this;
        }

        public Builder setRequestedDate(LocalDate requestedDate) {
            this.requestedDate = requestedDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setStudent(User student) {
            this.student = student;
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

        public Builder copy(BookingRequest bookingRequest) {
            this.tutoringSessionId = bookingRequest.tutoringSessionId;
            this.requestedDate = bookingRequest.requestedDate;
            this.status = bookingRequest.status;
            this.student = bookingRequest.student;
            this.tutorProfile = bookingRequest.tutorProfile;
            this.subject = bookingRequest.subject;
            return this;
        }

        public BookingRequest build() {
            return new BookingRequest(this);
        }
    }
}
