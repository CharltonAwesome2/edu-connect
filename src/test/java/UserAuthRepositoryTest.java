import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.repository.UserAuthRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserAuthRepositoryTest {
    private UserAuthRepository repository;
    private UserAuth userAuth;

    @BeforeEach
    void setUp() {
        repository = UserAuthRepository.getRepository();

        User user = new User.Builder()
                .setUserId(1L)
                .setName("Lesego")
                .setSurname("Tshabalala")
                .setStudentNumber("240263952")
                .setEmail("test@mail.com")
                .setContactNumber("1234567890")
                .setCreatedAt(LocalDateTime.now())
                .build();

        userAuth = new UserAuth.Builder()
                .setAuthId(100L)
                .passwordHash("hashedPassword123")
                .setCreatedAt(LocalDateTime.now())
                .setUser(user)
                .build();
    }

    @Test
    void testCreate() {
        UserAuth created = repository.create(userAuth);

        assertNotNull(created);
        assertEquals(userAuth.getAuthId(), created.getAuthId());
    }

    @Test
    void testRead() {
        repository.create(userAuth);

        UserAuth read = repository.read(userAuth.getAuthId());

        assertNotNull(read);
        assertEquals(userAuth.getAuthId(), read.getAuthId());
    }

    @Test
    void testUpdate() {
        repository.create(userAuth);

        UserAuth updatedAuth = new UserAuth.Builder()
                .copy(userAuth)
                .passwordHash("newPasswordHash")
                .build();

        UserAuth updated = repository.update(updatedAuth);

        assertNotNull(updated);
        assertEquals("newPasswordHash", updated.getPasswordHash());
    }

    @Test
    void testDelete() {
        repository.create(userAuth);

        boolean deleted = repository.delete(userAuth.getAuthId());

        assertTrue(deleted);
        assertNull(repository.read(userAuth.getAuthId()));
    }
}
