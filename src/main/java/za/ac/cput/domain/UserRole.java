package za.ac.cput.domain;

/*
    UserRole.java
    UserRole model class
    Author: Charlton Solomons (220483418)
    Date: 11 March 2026
*/

public class UserRole {

    private Long userRoleId;
    private User user;
    private Role role;

    public UserRole() {

    }

    public UserRole(Builder builder) {
        this.userRoleId = builder.userRoleId;
        this.user = builder.user;
        this.role = builder.role;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public User getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserRole [userRoleId=" + userRoleId + ", user=" + user + ", role=" + role + "]";
    }

    public static class Builder {

        private Long userRoleId;
        private User user;
        private Role role;

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setUserRoleId(Long userRoleId) {
            this.userRoleId = userRoleId;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;

        }

        public Builder copy(UserRole userRole) {
            this.userRoleId = userRole.userRoleId;
            this.user = userRole.user;
            this.role = userRole.role;
            return this;
        }

        public UserRole build() {
            return new UserRole(this);
        }
    }
}
