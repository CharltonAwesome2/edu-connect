package za.ac.cput.repository;

/*
 Notification.java
 Notification Entity
 Author:Nolwazi Zulu(220118876)
 Date: 16 March 2026
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.factory.NotificationFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NotificationRepositoryTest {

    private NotificationRepository repository;
    private Notification notification;

    @BeforeEach
    void setUp() {

        repository = NotificationRepositoryImpl.getRepository();


        notification = NotificationFactory.createNotification(
                "Test message",
                false,
                LocalDateTime.now(),
                new User()
        );
    }

    @Test
    void create() {
        Notification created = repository.create(notification);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        repository.create(notification);
        Notification read = repository.read(notification.getNotificationId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        repository.create(notification);

        Notification updated = new Notification.Builder()
                .copy(notification)
                .setMessage("Updated message")
                .build();

        Notification result = repository.update(updated);

        assertEquals("Updated message", result.getMessage());
        System.out.println("Updated: " + result);
    }

    @Test
    void delete() {
        repository.create(notification);
        boolean deleted = repository.delete(notification.getNotificationId());
        assertTrue(deleted);
        System.out.println("Deleted successfully");
    }
}
