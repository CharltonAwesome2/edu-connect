import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest {
    @Test
    void testCreateUserSuccess() {
        User user = UserFactory.createUser(
                "Lesego",
                "Tshabalala",
                "240263952",
                "test@mail.com",
                "1234567890"
        );

        assertNotNull(user);
        assertNotNull(user.getUserId());
        assertEquals("Lesego", user.getName());
        assertEquals("test@mail.com", user.getEmail());
    }

    @Test
    void testCreateUserFail_NullName() {
        User user = UserFactory.createUser(
                null,
                "Tshabalala",
                "240263952",
                "test@mail.com",
                "1234567890"
        );

        assertNull(user);
    }

    @Test
    void testCreateUserFail_EmptySurname() {
        User user = UserFactory.createUser(
                "Lesego",
                "",
                "240263952",
                "test@mail.com",
                "1234567890"
        );

        assertNull(user);
    }

    @Test
    void testCreateUserFail_InvalidEmail() {
        User user = UserFactory.createUser(
                "Lesego",
                "Tshabalala",
                "240263952",
                "invalid-email",
                "1234567890"
        );

        assertNull(user);
    }

    @Test
    void testCreateUserSuccess_MinimalValid() {
        User user = UserFactory.createUser(
                "A",
                "B",
                "123",
                "a@mail.com",
                "000"
        );

        assertNotNull(user);
    }
}
