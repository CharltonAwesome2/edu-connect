package za.ac.cput.factory;

/*
BookingRequestFactory.java
BookingRequest Factory class
Author: Reotshepile Stock (230875807)
Date: 23 March 2026
*/

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

public class BookingRequestFactory {

    public static BookingRequest createBookingRequest(
            LocalDateTime requestedStartTime, int durationMinutes, LocalDateTime createdAt, BookingStatus status,
            User student, TutorProfile tutorProfile, Subject subject) {

        Long tutoringSessionId = HelperUtil.generateId();

        if (requestedStartTime == null
                || durationMinutes < 0
                || createdAt == null
                || status == null
                || student == null
                || tutorProfile == null
                || subject == null) {
            return null;
        }

        return new BookingRequest.Builder()
                .setTutoringSessionId(tutoringSessionId)
                .setRequestedStartTime(requestedStartTime)
                .setDurationMinutes(durationMinutes)
                .setCreatedAt(createdAt)
                .setStatus(status)
                .setStudent(student)
                .setTutorProfile(tutorProfile)
                .setSubject(subject)
                .build();
    }
}

/*
    CS: 25-03-2026
    Code retrieved and amended from https://github.com/CharltonAwesome2/edu-connect/pull/51
*/