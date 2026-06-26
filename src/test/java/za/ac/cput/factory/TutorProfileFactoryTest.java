package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.TutorProfile;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TutorProfileFactoryTest.java
 * TutorProfileFactoryTest model class
 * Author: Esaile Franck Siani Djiakeng (220274142)
 * Date: 26 June 2026
 */

class TutorProfileFactoryTest {

    @Test
    void createTutorProfile() {
        TutorProfile profile = TutorProfileFactory.createTutorProfile(
                "Math and Stats tutor",
                3,
                250.0,
                4.5
        );

        assertNotNull(profile);
        assertNotNull(profile.getTutorProfileId());
        assertEquals("Math and Stats tutor", profile.getBio());
        assertEquals(3, profile.getYearsExperience());
        assertEquals(250.0, profile.getHourlyRate());
        assertEquals(4.5, profile.getAverageRating());
    }

    @Test
    void createTutorProfileWithBlankBio() {
        TutorProfile profile = TutorProfileFactory.createTutorProfile(
                "",
                3,
                250.0,
                4.5
        );

        assertNull(profile);
    }

    @Test
    void createTutorProfileWithInvalidHourlyRate() {
        TutorProfile profile = TutorProfileFactory.createTutorProfile(
                "Physics tutor",
                3,
                -1.0,
                4.0
        );

        assertNull(profile);
    }

    @Test
    void createTutorProfileWithInvalidRating() {
        TutorProfile profile = TutorProfileFactory.createTutorProfile(
                "Chemistry tutor",
                2,
                180.0,
                5.5
        );

        assertNull(profile);
    }
}