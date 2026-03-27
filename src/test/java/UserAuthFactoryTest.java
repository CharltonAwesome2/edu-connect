import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.factory.UserAuthFactory;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class UserAuthFactoryTest {
    private User createTestUser() {
        return new User.Builder()
                .setUserId(1L)
                .setName("Lesego")
                .setSurname("Tshabalala")
                .setStudentNumber("240263952")
                .setEmail("test@mail.com")
                .setContactNumber("1234567890")
                .setCreatedAt(LocalDateTime.now())
                .build();
    }

    @Test
    void testCreateUserAuthSuccess() {
        User user = createTestUser();

        UserAuth auth = UserAuthFactory.createUserAuth("password123", user);

        assertNotNull(auth);
        assertNotNull(auth.getAuthId());
        assertNotNull(auth.getPasswordHash());
        assertEquals(user, auth.getUser());

        assertNotEquals("password123", auth.getPasswordHash());
    }

    @Test
    void testCreateUserAuthFail_NullPassword() {
        User user = createTestUser();

        UserAuth auth = UserAuthFactory.createUserAuth(null, user);

        assertNull(auth);
    }

    @Test
    void testCreateUserAuthFail_EmptyPassword() {
        User user = createTestUser();

        UserAuth auth = UserAuthFactory.createUserAuth("", user);

        assertNull(auth);
    }

    @Test
    void testCreateUserAuthFail_NullUser() {
        UserAuth auth = UserAuthFactory.createUserAuth("password123", null);

        assertNull(auth);
    }

    @Test
    void testPasswordIsHashed() {
        User user = createTestUser();

        UserAuth auth = UserAuthFactory.createUserAuth("mypassword", user);

        assertNotNull(auth);
        assertNotEquals("mypassword", auth.getPasswordHash());
    }
}
