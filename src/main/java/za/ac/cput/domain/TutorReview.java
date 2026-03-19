package za.ac.cput.domain;

import java.time.LocalDateTime;

import za.ac.cput.enums.ReviewRating;

/* TutorReview.java
TutorReview domain model class
Author: Ayabonga Jervasio Yawa (221241558)
Date: 11 March 2026
*/
public class TutorReview {
    private Long reviewId;
    private String comment;
    private LocalDateTime reviewedAt;
    private ReviewRating rating;
    private User student;
    private TutoringSession session;
    //private Long sessionID

    private TutorReview(Builder builder) {
        this.reviewId = builder.reviewId;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.reviewedAt = builder.reviewedAt;
        this.student = builder.student;
        this.session = builder.session;
    }

    //Getters
    public Long getReviewId() {
        return reviewId;
    }

    public ReviewRating getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewedAt() {
        return reviewedAt;
    }

    public User getStudent() {
        return student;

    }

    public TutoringSession getSession() {
        return session;
    }

    @Override
    public String toString() {
        return "TutorReview{" +
                "reviewId=" + reviewId +
                ", comment='" + comment + '\'' +
                ", reviewedAt=" + reviewedAt +
                ", rating=" + rating +
                ", student=" + student +
                ", session=" + session +
                '}';
    }

    //Builder Class
    public static class Builder {
        private Long reviewId;
        private String comment;
        private LocalDateTime reviewedAt;
        private ReviewRating rating;
        private User student;
        private TutoringSession session;

        public Builder setReviewID(long reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setReviewedAt(LocalDateTime reviewDate) {
            this.reviewedAt = reviewDate;
            return this;
        }

        public Builder setRating(ReviewRating rating) {
            this.rating = rating;
            return this;
        }

        public Builder setStudent(User student) {
            this.student = student;
            return this;

        }

        public Builder setSession(TutoringSession session) {
            this.session = session;
            return this;
        }

        //Builder copy
        public Builder copy(TutorReview review) {
            this.reviewId = review.reviewId;
            this.comment = review.comment;
            this.reviewedAt = review.reviewedAt;
            this.rating = review.rating;
            this.student = review.student;
            this.session = review.session;
            return this;
        }

        public TutorReview build() {
            return new TutorReview(this);
        }
    }

}
