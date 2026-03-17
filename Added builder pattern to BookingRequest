package za.ac.cput.domain;

// BookingRequest.java
//Booking Request model class
//Author:Reotshepile Stock (230875807)
//Date:17 March 2026

import java.time.LocalDate;

public class BookingRequest {

    private Long tutoringSessionId;
    private LocalDate date;
    private Long userId;

    
    private BookingRequest(Builder builder) {
        this.tutoringSessionId = builder.tutoringSessionId;
        this.date = builder.date;
        this.userId = builder.userId;
    }

    public Long getTutoringSessionId() {
        return tutoringSessionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getUserId() {
        return userId;
    }


    @Override
    public String toString() {
        return "BookingRequest{" +
                "tutoringSessionId=" + tutoringSessionId +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }

    
    public static class Builder {

        private Long tutoringSessionId;
        private LocalDate date;
        private Long userId;

        public Builder setTutoringSessionId(Long tutoringSessionId) {
            this.tutoringSessionId = tutoringSessionId;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public BookingRequest build() {
            return new BookingRequest(this);
        }
    }
}
