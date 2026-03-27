package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReviewRating;

import java.time.LocalDateTime;

/* TutorReviewFactoryTest.java
     Tutor review Factrory Test class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 26 March 2026
*/

class TutorReviewFactoryTest {

    private User user = UserFactory.createUser("Ayabonga","Yawa", "221241558", "Aya@fake.com","0789003001");
    private TutorReview review = new TutorReview.Builder()
            .setReviewID(23l)
            .setComment("Very Helpful")
            .setReviewedAt(LocalDateTime.now())
            .setRating(ReviewRating.FIVE)
            .setUser(user)
            .setSession(new TutoringSession())
            .build();

    @Test
    void createTutorReview() {
        System.out.println(review);
    }
}

