package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReviewRating;
import za.ac.cput.factory.TutorReviewFactory;
import za.ac.cput.factory.UserFactory;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TutorReviewRepositoryTest {

    private ITutorReviewRepository repository = TutorReviewRepository.getRepository();

    private static User student1 = UserFactory.createUser("Ayabonga", "Yawa","20023","Aya@fake.com","0876106388");
    private static User student2 = UserFactory.createUser("Vasio", "Fall","20003","vasio@fake.com","0978306388");
    private static TutorReview review1 = TutorReviewFactory.createTutorReview(
            ReviewRating.FIVE,
            "Excellent tutor",
            LocalDateTime.now(),
            student1,
            new TutoringSession()
    );

    private static TutorReview review2 = TutorReviewFactory.createTutorReview(
            ReviewRating.FOUR,
            "Very helpful",
            LocalDateTime.now(),
            student2,
            new TutoringSession()
    );


    @Test
    @Disabled
    void getRepository() {
        assertNotNull(repository);
        System.out.println("Repository instance Exixts");
    }

    @Test
    @Order(1)
    void create() {
        TutorReview created = repository.create(review1);

        assertNotNull(created);
        assertNotNull(created.getReviewId());
        System.out.println("Created Review: " + created);
    }

    @Test
    @Order(2)
    void read() {
        repository.create(review1);

        Long id = review1.getReviewId();
        TutorReview found = repository.read(id);

        assertNotNull(found);
        assertEquals(ReviewRating.FIVE, found.getRating());
        System.out.println("Read Review: " + found);
    }

    @Test
    @Order(3)
    void update() {
        repository.create(review2);

        Long id = review2.getReviewId();

        TutorReview updatedReview = new TutorReview.Builder()
                .copy(review2)
                .setRating(ReviewRating.FIVE)
                .setComment("Updated review")
                .build();

        assertEquals(ReviewRating.FIVE, updatedReview.getRating());

        TutorReview updated = repository.update(updatedReview);
        assertNotNull(updated);

        System.out.println("Updated Review: " + updated);
    }
    @Test
    @Order(5)
    void delete() {
        repository.create(review2);

        Long id = review2.getReviewId();

        System.out.println("Deleting Review: " + review2);

        boolean deleted = repository.delete(id);

        assertTrue(deleted);

    }
    @Test
    @Order(4)
    void getAll() {
        System.out.println("Find All Reviews");

        List<TutorReview> reviewList = repository.getAll();

        assertNotNull(reviewList);
        System.out.println(reviewList);
    }


}