package za.ac.cput.domain;

import java.time.LocalDateTime;

public class UserAuth {
    private long authId;
    private String passwordHash;
    private String salt;
    private LocalDateTime createdAt;
    private User user;

    private UserAuth(Builder builder) {
        this.authId = builder.authId;
        this.passwordHash = builder.passwordHash;
        this.salt = builder.salt;
        this.createdAt = builder.createdAt;
        this.user = builder.user;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getAuthId() {
        return authId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public static class Builder {
        private long authId;
        private String passwordHash;
        private String salt;
        private LocalDateTime createdAt;
        private User user;

        public Builder authId(long authId) {
            this.authId = authId;
            return this;
        }

        public Builder passwordHash(String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }

        public Builder salt(String salt) {
            this.salt = salt;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public UserAuth build() {
            return new UserAuth(this);
        }
    }
}