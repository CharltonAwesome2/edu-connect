<!-- erd.md -->

### ERD (Entity-Relationship Diagram)

```mermaid
erDiagram

    User {
        bigint userId PK
        string name
        string surname
        string studentNumber UK
        string email UK
        string contactNumber
        datetime createdAt
    }

    UserAuth {
        bigint authId PK
        bigint userId FK "unique"
        string passwordHash
        datetime lastLogin
    }

    Role {
        bigint roleId PK
        string roleName UK
        string description
    }

    UserRole {
        bigint userRoleId PK
        bigint userId FK
        bigint roleId FK
    }

    Subject {
        bigint subjectId PK
        string subjectName
        string subjectCode UK
        string department
    }

    TutorProfile {
        bigint tutorProfileId PK
        bigint userId FK "unique"
        string bio
        int yearsExperience
        double hourlyRate
        double averageRating
        datetime createdAt
    }

    TutorSubject {
        bigint tutorSubjectId PK
        bigint tutorProfileId FK
        bigint subjectId FK
    }

    BookingRequest {
        bigint bookingRequestId PK
        bigint studentId FK
        bigint tutorProfileId FK
        bigint subjectId FK
        datetime requestedStartTime
        int durationMinutes
        BookingStatus status
        datetime createdAt
    }

    TutoringSession {
        bigint sessionId PK
        bigint tutorProfileId FK
        bigint studentId FK
        bigint subjectId FK
        datetime startTime
        datetime endTime
        SessionStatus status
        datetime createdAt
    }

    TutorReview {
        bigint reviewId PK
        bigint sessionId FK "unique"
        bigint studentId FK
        ReviewRating rating
        string comment
        datetime reviewedAt
    }

    Payment {
        bigint paymentId PK
        bigint sessionId FK "unique"
        double amount
        PaymentStatus status
        datetime paidAt
        string paymentMethod
    }

    Notification {
        bigint notificationId PK
        bigint userId FK
        string message
        boolean isRead
        datetime createdAt
    }

    Report {
        bigint reportId PK
        bigint reporterId FK
        bigint reportedUserId FK
        string reason
        datetime reportedAt
    }

    %% ENUM-LIKE TYPES (conceptual)
    BookingStatus {
        str PENDING
        str APPROVED
        str REJECTED
        str CANCELED
    }

    SessionStatus {
       str SCHEDULED
       str IN_PROGRESS
       str COMPLETED
       str CANCELED
       str NO_SHOW
    }

    PaymentStatus {
        str PENDING
        str PAID
        str REFUNDED
        str FAILED
    }

    ReviewRating {
        str ONE
        str TWO
        str THREE
        str FOUR
        str FIVE
    }

    %% Relationships

    User ||--|| UserAuth : has
    User ||--o{ UserRole : has
    Role ||--o{ UserRole : assigned

    User ||--o| TutorProfile : owns

    TutorProfile ||--o{ TutorSubject : teaches
    Subject ||--o{ TutorSubject : belongs

    User ||--o{ BookingRequest : creates
    BookingRequest ||--|| TutorProfile : forTutor
    BookingRequest ||--|| Subject : forSubject

    User ||--o{ TutoringSession : attends
    TutorProfile ||--o{ TutoringSession : conducts
    Subject ||--o{ TutoringSession : covers

    TutoringSession ||--o| TutorReview : has
    TutoringSession ||--o| Payment : has

    User ||--o{ TutorReview : writes

    User ||--o{ Notification : receives

    User ||--o{ Report : reporter
    User ||--o{ Report : reported