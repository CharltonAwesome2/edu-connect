package za.ac.cput.repository;

import za.ac.cput.domain.BookingRequest;

import java.util.HashSet;
import java.util.Set;

public class BookingRequestRepository {

    private Set<BookingRequest> bookingDB = new HashSet<>();

    public BookingRequest create(BookingRequest booking) {
        bookingDB.add(booking);
        return booking;
    }

    public BookingRequest read(Long tutoringSessionId) {
        return bookingDB.stream()
                .filter(b -> b.getTutoringSessionId().equals(tutoringSessionId))
                .findAny()
                .orElse(null);
    }

    public BookingRequest update(BookingRequest booking) {
        BookingRequest oldBooking = read(booking.getTutoringSessionId());
        if (oldBooking != null) {
            bookingDB.remove(oldBooking);
            bookingDB.add(booking);
            return booking;
        }
        return null;
    }

    public boolean delete(Long tutoringSessionId) {
        BookingRequest booking = read(tutoringSessionId);
        if (booking != null) {
            bookingDB.remove(booking);
            return true;
        }
        return false;
    }

    public Set<BookingRequest> getAll() {
        return bookingDB;
    }
}
