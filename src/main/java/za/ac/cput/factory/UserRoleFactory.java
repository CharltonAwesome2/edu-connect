package za.ac.cput.factory;

import za.ac.cput.domain.UserRole;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Role;
import za.ac.cput.util.HelperUtil;

/*
    UserRoleFactory.java
    UserRole factory class
    Author: Charlton Solomons (220483418)
    Date: 19 March 2026
*/

public class UserRoleFactory {

    public static UserRole createUserRole(User user, Role role) {

        Long userRoleId = HelperUtil.generateId();

        if (user == null || role == null) {
            return null;
        }

        return new UserRole.Builder()
                .setUserRoleId(userRoleId)
                .setUser(user)
                .setRole(role)
                .build();
    }
}
