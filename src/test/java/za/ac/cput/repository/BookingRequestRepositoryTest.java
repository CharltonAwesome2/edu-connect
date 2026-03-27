package za.ac.cput.repository;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;
import za.ac.cput.factory.BookingRequestFactory;

import java.time.LocalDateTime;

public class BookingRequestRepositoryTest {

    public static void main(String[] args) {

        BookingRequestRepository repo = new BookingRequestRepository();

        BookingRequest booking = BookingRequestFactory.createBookingRequest(
                LocalDateTime.now(),
                0,
                LocalDateTime.now(),
                BookingStatus.APPROVED,
                new User(),
                new TutorProfile(),
                new Subject()
        );

        repo.create(booking);
        System.out.println("Created: " + booking);

        BookingRequest read = repo.read(booking.getTutoringSessionId());
        System.out.println("Read: " + read);

        BookingRequest updated = new BookingRequest.Builder()
                .setTutoringSessionId(booking.getTutoringSessionId())
                .setCreatedAt(LocalDateTime.now().plusDays(1))
                .build();

        repo.update(updated);
        System.out.println("Updated: " + updated);

        repo.delete(booking.getTutoringSessionId());
        System.out.println("Deleted");

        System.out.println("All Bookings: " + repo.getAll());
    }
}
