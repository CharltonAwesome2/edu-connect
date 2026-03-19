<!-- uml.md -->

### UML (Unified Modeling Language)

```mermaid
classDiagram

class User:::lesego {
    Long userId
    String name
    String surname
    String studentNumber
    String email
    String contactNumber
    LocalDateTime createdAt

    register()
    updateProfile()
}

class UserAuth:::lesego {
    Long authId
    String passwordHash
    String salt
    LocalDateTime lastLogin

    User user

    login()
    logout()
    updatePassword()
}

class Role:::charlton {
    Long roleId
    String roleName
    String description
}

class UserRole:::charlton {
    Long userRoleId

    User user
    Role role
}

class Subject:::reotshepile {
    Long subjectId
    String subjectName
    String subjectCode
    String department
}

class TutorProfile:::franck {
    Long tutorProfileId
    String bio
    int yearsExperience
    double hourlyRate
    double averageRating
    LocalDateTime createdAt

    User user

    updateBio()
    updateRate()
}

class TutorSubject:::franck {
    Long tutorSubjectId

    TutorProfile tutorProfile
    Subject subject
}

class BookingStatus {
    <<enumeration>>
    PENDING
    APPROVED
    REJECTED
    CANCELLED
}

class BookingRequest:::reotshepile {
    Long bookingRequestId
    LocalDateTime requestedStartTime
    int durationMinutes
    LocalDateTime createdAt

    BookingStatus status
    User student
    TutorProfile tutorProfile
    Subject subject

    approveRequest()
    rejectRequest()
}

class SessionStatus {
    <<enumeration>>
    SCHEDULED
    IN_PROGRESS
    COMPLETED
    CANCELLED
    NO_SHOW
}

class TutoringSession:::franck {
    Long sessionId
    LocalDateTime startTime
    LocalDateTime endTime
    LocalDateTime createdAt

    SessionStatus status
    TutorProfile tutor
    User student
    Subject subject

    startSession()
    endSession()
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
    Long reviewId
    String comment
    LocalDateTime reviewedAt

    ReviewRating rating
    User student
    TutoringSession session

    submitReview()
}

class PaymentStatus {
    <<enumeration>>
    PENDING
    PAID
    REFUNDED
    FAILED
}

class Payment:::ayabonga {
    Long paymentId
    double amount
    LocalDateTime paidAt
    String paymentMethod

    PaymentStatus status
    TutoringSession session

    processPayment()
}

class Notification:::nolwazi {
    Long notificationId
    String message
    boolean isRead
    LocalDateTime createdAt

    User user

    markAsRead()
}

class Report:::nolwazi {
    Long reportId
    String reason
    LocalDateTime reportedAt

    User reporter
    User reportedUser

    submitReport()
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