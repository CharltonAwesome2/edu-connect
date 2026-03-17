package za.ac.cput.domain;

import java.time.LocalDateTime;

/* TutorReview.java
TutorReview domain model class
Author: Ayabonga Jervasio Yawa (221241558)
Date: 11 March 2026
*/
public class TutorReview {
    private Long reviewId;
    private int rating;
    private String comment;
    private LocalDateTime reviewDate;
    private User student;
    private TutoringSession session;
    //private Long sessionID

    private TutorReview(Builder builder) {
        this.reviewId = builder.reviewId;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.reviewDate = builder.reviewDate;
        this.student = builder.student;
        this.session = builder.session;
    }

    //Review submission method
    public void submitReview() {

    }

    //Getters
    public Long getReviewId() {
        return reviewId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
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
                "reviewID=" + reviewId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                ", student=" + student +
                ", session=" + session +
                '}';
    }

    //Builder Class
    public static class Builder {
        private Long reviewId;
        private int rating;
        private String comment;
        private LocalDateTime reviewDate;
        private User student;
        private TutoringSession session;


        public Builder setReviewID(long reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setReviewDate(LocalDateTime reviewDate) {
            this.reviewDate = reviewDate;
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
            this.rating = review.rating;
            this.comment = review.comment;
            this.reviewDate = review.reviewDate;
            this.student = review.student;
            this.session = review.session;
            return this;
        }

        public TutorReview build() {
            return new TutorReview(this);
        }
    }


}
