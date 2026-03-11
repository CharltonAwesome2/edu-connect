package za.ac.cput.domain;

// import java.util.List;
// import java.util.ArrayList;

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
    // private List<User> users;

    public Role() {

    }

    public Role(Builder builder) {
        this.roleId = builder.roleId;
        this.roleName = builder.roleName;
        this.description = builder.description;
        // Deep copy / Defensive copy
        // https://stackoverflow.com/questions/7042182/how-to-make-a-deep-copy-of-java-arraylist
        // https://www.baeldung.com/java-copy-list-to-another
        // this.users = new ArrayList<>(builder.users);

        // List<User> deepUserList = new ArrayList<>();

        // if (builder.users != null) {
        //     for (User user : builder.users) {
        //         if (user != null) {
        //             deepUserList.add(user.copy());
        //         }
        //     }
        // }

        // this.users = deepUserList;
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

    // public List<User> getUsers() {
    //     // defensive copy
    //     List<User> deepUserList = new ArrayList<>();
    //     if (this.users != null) {
    //         for (User user : this.users) {
    //             deepUserList.add(user.copy());
    //         }
    //     }
    //     return deepUserList;
    // }

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

        // public Builder users(List<User> users) {
        //     List<User> deepUserList = new ArrayList<>();

        //     if (users != null) {
        //         for (User user : users) {
        //             if (user != null) {
        //                 deepUserList.add(user.copy());
        //             }
        //         }
        //     }
        //     this.users = deepUserList;

        //     return this;
        // }

        public Builder copy(Role role) {
            this.roleId = role.roleId;
            this.roleName = role.roleName;
            this.description = role.description;

            // List<User> deepUserList = new ArrayList<>();

            // if (role.users != null) {

            //     for (User user : role.users) {
            //         if (user != null) {
            //             deepUserList.add(user.copy());
            //             ;
            //         }
            //     }
            // }

            // this.users = deepUserList;
            return this;

        }

        public Role build() {
            return new Role(this);
        }
    }

}
