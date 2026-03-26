import za.ac.cput.domain.User;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void testUserBuilder() {
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

        assertNotNull(user);
        assertEquals(1L, user.getUserId());
        assertEquals("Lesego", user.getName());
        assertEquals("Tshabalala", user.getSurname());
        assertEquals("240263952", user.getStudentNumber());
        assertEquals("test@mail.com", user.getEmail());
        assertEquals("1234567890", user.getContactNumber());
        assertEquals(now, user.getCreatedAt());
    }

    @Test
    void testCopy() {
        LocalDateTime now = LocalDateTime.now();

        User original = new User.Builder()
                .setUserId(1L)
                .setName("Lesego")
                .setSurname("Tshabalala")
                .setStudentNumber("240263952")
                .setEmail("test@mail.com")
                .setContactNumber("1234567890")
                .setCreatedAt(now)
                .build();

        User copy = new User.Builder()
                .copy(original)
                .build();

        assertNotNull(copy);
        assertEquals(original.getUserId(), copy.getUserId());
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getSurname(), copy.getSurname());
        assertEquals(original.getStudentNumber(), copy.getStudentNumber());
        assertEquals(original.getEmail(), copy.getEmail());
        assertEquals(original.getContactNumber(), copy.getContactNumber());
        assertEquals(original.getCreatedAt(), copy.getCreatedAt());
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

        String result = user.toString();

        assertNotNull(result);
        assertTrue(result.contains("Lesego"));
        assertTrue(result.contains("Tshabalala"));
        assertTrue(result.contains("test@mail.com"));
    }
}
