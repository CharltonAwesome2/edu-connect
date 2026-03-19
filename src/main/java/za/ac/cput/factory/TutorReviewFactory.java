package za.ac.cput.factory;

import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

/*
    TutorReviewFactory.java
    Factory class for TutorReview domain
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 18 March 2026
*/
public class TutorReviewFactory {
    public static TutorReview createTutorReview(Long reviewID, Integer rating, String comment, LocalDateTime reviewDate,
                                                User student, TutoringSession session) {
//        if (reviewID == null ||
//                rating == null ||
//                comment == null ||
//                reviewDate == null ||
//                student == null ||
//                session == null) {
//            return null;
//
//
//        }

        if(Helper.isObjectNull(reviewID)
        || Helper.isEmptyOrNull(comment)
        || Helper.isObjectNull(student)
        || Helper.isObjectNull(session)
        ){
            return null;
        }

        if(rating < 0 || rating > 5){
            return null;
        }

        if (reviewDate == null) {
            reviewDate = LocalDateTime.now();
        }

        return new TutorReview.Builder()
                .setReviewID(reviewID)
                .setRating(rating)
                .setComment(comment)
                .setReviewDate(reviewDate)
                .setStudent(student)
                .setSession(session)
                .build();
    }
}
