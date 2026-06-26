<!-- uml.md -->

### UML (Unified Modeling Language)

```mermaid
classDiagram

class User:::lesego {
    &minus; Long userId
    &minus; String name
    &minus; String surname
    &minus; String studentNumber
    &minus; String email
    &minus; String contactNumber
    &minus; LocalDateTime createdAt
}

class UserAuth:::lesego {
    &minus; Long authId
    &minus; String passwordHash
    &minus; LocalDateTime lastLogin
    &minus; User user
}

class Role:::charlton {
    &minus; Long roleId
    &minus; String roleName
    &minus; String description
}

class UserRole:::charlton {
    &minus; Long userRoleId
    &minus; User user
    &minus; Role role
}

class Subject:::reotshepile {
    &minus; Long subjectId
    &minus; String subjectName
    &minus; String subjectCode
    &minus; String department
}

class TutorProfile:::franck {
    &minus; Long tutorProfileId
    &minus; String bio
    &minus; int yearsExperience
    &minus; double hourlyRate
    &minus; double averageRating
    &minus; LocalDateTime createdAt
    &minus; User user

    }

class TutorSubject:::franck {
    &minus; Long tutorSubjectId
    &minus; TutorProfile tutorProfile
    &minus; Subject subject
}

class BookingStatus {
    <<enumeration>>
    PENDING
    APPROVED
    REJECTED
    CANCELED
}

class BookingRequest:::reotshepile {
    &minus; Long bookingRequestId
    &minus; LocalDateTime requestedStartTime
    &minus; int durationMinutes
    &minus; LocalDateTime createdAt
    &minus; BookingStatus status
    &minus; User user
    &minus; TutorProfile tutorProfile
    &minus; Subject subject

    }

class SessionStatus {
    <<enumeration>>
    SCHEDULED
    IN_PROGRESS
    COMPLETED
    CANCELED
    NO_SHOW
}

class TutoringSession:::franck {
    &minus; Long sessionId
    &minus; LocalDateTime startTime
    &minus; LocalDateTime endTime
    &minus; LocalDateTime createdAt
    &minus; SessionStatus status
    &minus; TutorProfile tutor
    &minus; User user
    &minus; Subject subject

    }

class ReviewRating {
    <<enumeration>>
    ONE
    TWO
    THREE
    FOUR
    FIVE
}

class TutorReview:::ayabonga {
    &minus; Long reviewId
    &minus; String comment
    &minus; LocalDateTime reviewedAt
    &minus; ReviewRating rating
    &minus; User user
    &minus; TutoringSession session

    }

class PaymentStatus {
    <<enumeration>>
    PENDING
    PAID
    REFUNDED
    FAILED
}

class Payment:::ayabonga {
    &minus; Long paymentId
    &minus; double amount
    &minus; LocalDateTime paidAt
    &minus; String paymentMethod
    &minus; PaymentStatus status
    &minus; TutoringSession session

    }

class Notification:::nolwazi {
    &minus; Long notificationId
    &minus; String message
    &minus; boolean isRead
    &minus; LocalDateTime createdAt
    &minus; User user

    }

class Report:::nolwazi {
    &minus; Long reportId
    &minus; String reason
    &minus; LocalDateTime reportedAt
    &minus; User reporter
    &minus; User reportedUser

    }

%% Relationships

User "1" --> "1" UserAuth
User "1" --> "many" UserRole
Role "1" --> "many" UserRole

User "1" --> "0..1" TutorProfile

TutorProfile "1" --> "many" TutorSubject
Subject "1" --> "many" TutorSubject

BookingRequest --> TutorProfile
BookingRequest --> Subject
BookingRequest --> User
BookingRequest --> BookingStatus

TutoringSession --> TutorProfile
TutoringSession --> Subject
TutoringSession --> User
TutoringSession --> SessionStatus

TutorReview --> TutoringSession
TutorReview --> User
TutorReview --> ReviewRating

Payment --> TutoringSession
Payment --> PaymentStatus

Notification --> User

Report --> User

class Legend:::legend {
    Green  : Franck - Tutor System
    Blue   : Charlton - Roles & Permissions
    Purple : Lesego - User Management
    Orange : Nolwazi - Notifications & Reports
    Teal   : Reotshepile - Subjects & Booking
    Pink   : Ayabonga - Reviews & Payments
}

classDef legend fill:#FFFFFF,stroke:#333,stroke-width:2px;

classDef franck fill:#C8E6C9,stroke:#2E7D32,stroke-width:2px;
classDef charlton fill:#BBDEFB,stroke:#1565C0,stroke-width:2px;
classDef lesego fill:#E1BEE7,stroke:#6A1B9A,stroke-width:2px;
classDef nolwazi fill:#FFE0B2,stroke:#EF6C00,stroke-width:2px;
classDef reotshepile fill:#B2DFDB,stroke:#00695C,stroke-width:2px;
classDef ayabonga fill:#F8BBD0,stroke:#AD1457,stroke-width:2px;