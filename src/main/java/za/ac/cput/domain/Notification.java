package za.ac.cput.domain;

/*
 Notification.java
 Notification Entity
 Author:Nolwazi Zulu(220118876)
 Date: 16 March 2026
*/

public class Notification {

    private Long notificationId;
    private String message;
    private String date;
    private Long userId;

    private Notification() {}

    private Notification(Builder builder){
        this.notificationId = builder.notificationId;
        this.message = builder.message;
        this.date = builder.date;
        this.userId = builder.userId;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public Long getUserId() {
        return userId;
    }

    public static class Builder {

        private Long notificationId;
        private String message;
        private String date;
        private Long userId;

        public Builder setNotificationId(Long notificationId){
            this.notificationId = notificationId;
            return this;
        }

        public Builder setMessage(String message){
            this.message = message;
            return this;
        }

        public Builder setDate(String date){
            this.date = date;
            return this;
        }

        public Builder setUserId(Long userId){
            this.userId = userId;
            return this;
        }

        public Notification build(){
            return new Notification(this);
        }
    }
}