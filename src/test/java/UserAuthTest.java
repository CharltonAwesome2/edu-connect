import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class UserAuthTest {
    @Test
    void testUserAuthBuilder() {
        LocalDateTime now = LocalDateTime.now();

        User user = new User.Builder()
                .setUserId(1L)
                .setName("Lesego")
                .setSurname("Tshabalala")
                .setStudentNumber("240263952")
                .setEmail("test@mail.com")
                .setContactNumber("1234567890")
                .setCreatedAt(now)
                .build();

        UserAuth auth = new UserAuth.Builder()
                .setAuthId(100L)
                .passwordHash("hashedPassword123")
                .setCreatedAt(now)
                .setUser(user)
                .build();

        assertNotNull(auth);
        assertEquals(100L, auth.getAuthId());
        assertEquals("hashedPassword123", auth.getPasswordHash());
        assertEquals(now, auth.getCreatedAt());
        assertEquals(user, auth.getUser());
    }

    @Test
    void testCopy() {
        LocalDateTime now = LocalDateTime.now();

        User user = new User.Builder()
                .setUserId(1L)
                .setName("Lesego")
                .setSurname("Tshabalala")
                .setStudentNumber("240263952")
                .setEmail("test@mail.com")
                .setContactNumber("1234567890")
                .setCreatedAt(now)
                .build();

        UserAuth original = new UserAuth.Builder()
                .setAuthId(100L)
                .passwordHash("hashedPassword123")
                .setCreatedAt(now)
                .setUser(user)
                .build();

        UserAuth copy = new UserAuth.Builder()
                .copy(original)
                .build();

        assertNotNull(copy);
        assertEquals(original.getAuthId(), copy.getAuthId());
        assertEquals(original.getPasswordHash(), copy.getPasswordHash());
        assertEquals(original.getCreatedAt(), copy.getCreatedAt());
        assertEquals(original.getUser(), copy.getUser());
    }

    @Test
    void testToString() {
        LocalDateTime now = LocalDateTime.now();

        User user = new User.Builder()
                .setUserId(1L)
                .setName("Lesego")
                .setSurname("Tshabalala")
                .setStudentNumber("240263952")
                .setEmail("test@mail.com")
                .setContactNumber("1234567890")
                .setCreatedAt(now)
                .build();

        UserAuth auth = new UserAuth.Builder()
                .setAuthId(100L)
                .passwordHash("hashedPassword123")
                .setCreatedAt(now)
                .setUser(user)
                .build();

        String result = auth.toString();

        assertNotNull(result);
        assertTrue(result.contains("hashedPassword123"));
        assertTrue(result.contains("100"));
    }
}
