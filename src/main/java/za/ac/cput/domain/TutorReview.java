package za.ac.cput.domain;

public class TutorReview {

        private Long reviewId;
        private int rating;
        private String comment;

        public TutorReview(Long reviewId, int rating, String comment){
            this.reviewId = reviewId;
            this.rating = rating;
            this.comment = comment;
        }

        public Long getReviewId(){
            return reviewId;
        }

        public int getRating(){
            return rating;
        }

        public String getComment(){
            return comment;
        }

        @Override
        public String toString(){
            return "TutorReview{" +
                    "reviewId=" + reviewId +
                    ", rating=" + rating +
                    ", comment='" + comment + '\'' +
                    '}';
        }
    }

