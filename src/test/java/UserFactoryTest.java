import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.factory.userFactory;

import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest {
    @Test
    void testCreateUserSuccess() {
        User user = userFactory.createUser(
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
        User user = userFactory.createUser(
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
        User user = userFactory.createUser(
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
        User user = userFactory.createUser(
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
        User user = userFactory.createUser(
                "A",
                "B",
                "123",
                "a@mail.com",
                "000"
        );

        assertNotNull(user);
    }
}
