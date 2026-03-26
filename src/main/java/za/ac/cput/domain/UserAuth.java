package za.ac.cput.domain;

import java.time.LocalDateTime;

/**
 * UserAuth.java
 * UserAuth model class
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 11 March 2026
 */

public class UserAuth {
    private long authId;
    private String passwordHash;
    private LocalDateTime createdAt;
    private User user;

    private UserAuth(Builder builder) {
        this.authId = builder.authId;
        this.passwordHash = builder.setPasswordHash;
        this.createdAt = builder.createdAt;
        this.user = builder.user;
    }

    public long getAuthId() {
        return authId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }


    @Override
    public String toString() {
        return "UserAuth [authId=" + authId + ", passwordHash=" + passwordHash + ", createdAt="
                + createdAt + ", user=" + user + "]";
    }

    public static class Builder {
        private long authId;
        private String setPasswordHash;
        private LocalDateTime createdAt;
        private User user;

        public Builder setAuthId(long authId) {
            this.authId = authId;
            return this;
        }

        public Builder passwordHash(String passwordHash) {
            this.setPasswordHash = passwordHash;
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

        public Builder copy(UserAuth userAuth) {
            this.authId = userAuth.authId;
            this.setPasswordHash = userAuth.passwordHash;
            this.createdAt = userAuth.createdAt;
            this.user = userAuth.user;
            return this;
        }

        public UserAuth build() {
            return new UserAuth(this);
        }
    }
}