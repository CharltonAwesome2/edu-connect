package za.ac.cput.domain;

import java.time.LocalDateTime;
import java.util.List;
//import java.util.ArrayList;

public class User {
    private long userId;
    private String name;
    private String surname;
    private String studentNumber;
    private String email;
    private String contactNumber;
    private LocalDateTime createdAt;
    //private List<UserRole> roles;
    //private List<Notification> notifications;
    //private List<Report> reportsFiled;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.studentNumber = builder.studentNumber;
        this.email = builder.email;
        this.contactNumber = builder.contactNumber;
        this.createdAt = builder.createdAt;
        //this.roles = builder.roles != null ? new ArrayList<>(builder.roles) : new ArrayList<>();
        //this.notifications = builder.notifications != null ? new ArrayList<>(builder.notifications) : new ArrayList<>();
        //this.reportsFiled = builder.reportsFiled != null ? new ArrayList<>(builder.reportsFiled) : new ArrayList<>();
    }

    public static Builder builder() {
        return new Builder();
    }


    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static class Builder {
        private long userId;
        private String name;
        private String surname;
        private String studentNumber;
        private String email;
        private String contactNumber;
        private LocalDateTime createdAt;
        //private List<UserRole> roles;
        //private List<Notification> notifications;
        //private List<Report> reportsFiled;

        public Builder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder studentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        //waiting for other classes to be implemented before adding these

        /*public Builder roles(List<UserRole> roles) {
            this.roles = roles;
            return this;
        }

        public Builder notifications(List<Notification> notifications) {
            this.notifications = notifications;
            return this;
        }

        public Builder reportsFiled(List<Report> reportsFiled) {
            this.reportsFiled = reportsFiled;
            return this;
        }*/

        public User build() {
            return new User(this);
        }
    }
}
