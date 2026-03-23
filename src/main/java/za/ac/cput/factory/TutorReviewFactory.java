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
    public static TutorReview createTutorReview(ReviewRating rating, String comment,
            LocalDateTime reviewDate,
            User student, TutoringSession session) {

        Long reviewID = HelperUtil.generateId();

        if (rating == null
                || HelperUtil.isNullorEmpty(comment)
                || reviewDate == null
                || student == null
                || session == null) {
            return null;
        }

        return new TutorReview.Builder()
                .setReviewID(reviewID)
                .setComment(comment)
                .setReviewedAt(reviewDate)
                .setRating(rating)
                .setStudent(student)
                .setSession(session)
                .build();
    }
}
