package za.ac.cput.factory;

import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReviewRating;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

/*
    TutorReviewFactory.java
    Factory class for TutorReview domain
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 March 2026
*/
public class TutorReviewFactory {
    public static TutorReview createTutorReview(ReviewRating rating, String comment, LocalDateTime reviewDate,
                                                User student, TutoringSession session) {

        Long reviewID = HelperUtil.generateId();

        if (rating == null
                || comment== null
                || student == null
                || session == null) {
            return null;
        }
        if (reviewDate == null) {
            reviewDate = LocalDateTime.now();
        }

        return new TutorReview.Builder()
                .setReviewID(reviewID)
                .setRating(rating)
                .setComment(comment)
                .setReviewedAt(reviewDate)
                .setUser(student)
                .setSession(session)
                .build();
    }
}
