import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    private UserRepository repository;
    private User user;

    @BeforeEach
    void setUp() {
        repository = UserRepository.getRepository();

        user = new User.Builder()
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
    void testCreate() {
        User created = repository.create(user);

        assertNotNull(created);
        assertEquals(user.getUserId(), created.getUserId());
    }

    @Test
    void testRead() {
        repository.create(user);

        User read = repository.read(user.getUserId());

        assertNotNull(read);
        assertEquals(user.getUserId(), read.getUserId());
    }

    @Test
    void testUpdate() {
        repository.create(user);

        User updatedUser = new User.Builder()
                .copy(user)
                .setName("UpdatedName")
                .build();

        User updated = repository.update(updatedUser);

        assertNotNull(updated);
        assertEquals("UpdatedName", updated.getName());
    }

    @Test
    void testDelete() {
        repository.create(user);

        boolean deleted = repository.delete(user.getUserId());

        assertTrue(deleted);
        assertNull(repository.read(user.getUserId()));
    }
}
