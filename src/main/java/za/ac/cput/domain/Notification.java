package za.ac.cput.domain;

import java.time.LocalDateTime;

/*
 Notification.java
 Notification Entity
 Author:Nolwazi Zulu(220118876)
 Date: 16 March 2026
*/

public class Notification {

    private Long notificationId;
    private String message;
    private boolean isRead;
    private LocalDateTime createdAt;
    private User user;

    private Notification() {
    }

    private Notification(Builder builder) {
        this.notificationId = builder.notificationId;
        this.message = builder.message;
        this.isRead = builder.isRead;
        this.createdAt = builder.createdAt;
        this.user = builder.user;
    }

    public void markAsRead(){
        
    }

    @Override
    public String toString() {
        return "Notification [notificationId=" + notificationId + ", message=" + message + ", isRead=" + isRead
                + ", createdAt=" + createdAt + ", user=" + user + "]";
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public static class Builder {

        private Long notificationId;
        private String message;
        private boolean isRead;
        private LocalDateTime createdAt;
        private User user;

        public Builder setNotificationId(Long notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setRead(boolean isRead) {
            this.isRead = isRead;
            return this;
        }

        public Builder copy(Notification notification) {
            this.notificationId = notification.notificationId;
            this.message = notification.message;
            this.isRead = notification.isRead;
            this.createdAt = notification.createdAt;
            this.user = notification.user;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}