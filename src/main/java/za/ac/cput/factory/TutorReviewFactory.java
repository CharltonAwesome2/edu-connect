package za.ac.cput.factory;

import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReviewRating;
import za.ac.cput.util.Helper;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

/*
    TutorReviewFactory.java
    Factory class for TutorReview domain
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 March 2026
*/
public class TutorReviewFactory {
    public static TutorReview createTutorReview(Long reviewID, ReviewRating rating, String comment, LocalDateTime reviewDate,
                                                User student, TutoringSession session) {


        if (HelperUtil.isObjectNull(reviewID)
                || HelperUtil.isObjectNull(rating)
                || HelperUtil.isNullorEmpty(comment)
                || HelperUtil.isObjectNull(student)
                || HelperUtil.isObjectNull(session)) {
            return null;
        }

        if (HelperUtil.isObjectNull(reviewDate)) {
            reviewDate = LocalDateTime.now();
        }

        return new TutorReview.Builder()
                .setReviewedID(reviewID)
                .setRating(rating)
                .setComment(comment)
                .setReviewedAt(reviewDate)
                .setStudent(student)
                .setSession(session)
                .build();
    }
}
