package za.ac.cput.domain;

/*
    Role.java
    Role model class
    Author: Charlton Solomons (220483418)
    Date: 11 March 2026
*/

public class Role {

    private Long roleId;
    private String roleName;
    private String description;

    public Role() {

    }

    public Role(Builder builder) {
        this.roleId = builder.roleId;
        this.roleName = builder.roleName;
        this.description = builder.description;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {

        private Long roleId;
        private String roleName;
        private String description;
        // private List<User> users;

        public Builder roleId(Long roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Role role) {
            this.roleId = role.roleId;
            this.roleName = role.roleName;
            this.description = role.description;
            return this;

        }

        public Role build() {
            return new Role(this);
        }
    }

}
