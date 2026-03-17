package za.ac.cput.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 * User.java
 * User model class
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 11 March 2026
 */

public class User {
    private long userId;
    private String name;
    private String surname;
    private String studentNumber;
    private String email;
    private String contactNumber;
    private LocalDateTime createdAt;
    private List<UserRole> roles;
    private List<Notification> notifications;
    private List<Report> reportsFiled;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.studentNumber = builder.studentNumber;
        this.email = builder.email;
        this.contactNumber = builder.contactNumber;
        this.createdAt = builder.createdAt;
        this.roles = builder.roles != null ? new ArrayList<>(builder.roles) : new ArrayList<>();
        this.notifications = builder.notifications != null ? new ArrayList<>(builder.notifications) : new ArrayList<>();
        this.reportsFiled = builder.reportsFiled != null ? new ArrayList<>(builder.reportsFiled) : new ArrayList<>();
    }

    public void register(){

    }

    public void updateProfile(){
        
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

    public List<UserRole> getRoles() {
        return roles;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public List<Report> getReportsFiled() {
        return reportsFiled;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", surname=" + surname + ", studentNumber=" + studentNumber
                + ", email=" + email + ", contactNumber=" + contactNumber + ", createdAt=" + createdAt + ", roles="
                + roles + ", notifications=" + notifications + ", reportsFiled=" + reportsFiled + "]";
    }

    public static class Builder {
        private long userId;
        private String name;
        private String surname;
        private String studentNumber;
        private String email;
        private String contactNumber;
        private LocalDateTime createdAt;
        private List<UserRole> roles;
        private List<Notification> notifications;
        private List<Report> reportsFiled;

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        //waiting for other classes to be implemented before adding these

        public Builder setRoles(List<UserRole> roles) {
            this.roles = roles;
            return this;
        }

        public Builder setNotifications(List<Notification> notifications) {
            this.notifications = notifications;
            return this;
        }

        public Builder setReportsFiled(List<Report> reportsFiled) {
            this.reportsFiled = reportsFiled;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.name = user.name;
            this.surname = user.surname;
            this.studentNumber = user.studentNumber;
            this.email = user.email;
            this.contactNumber = user.contactNumber;
            this.createdAt = user.createdAt;
            this.roles = user.roles != null ? new ArrayList<>(user.roles) : new ArrayList<>();
            this.notifications = user.notifications != null ? new ArrayList<>(user.notifications) : new ArrayList<>();
            this.reportsFiled = user.reportsFiled != null ? new ArrayList<>(user.reportsFiled) : new ArrayList<>();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
