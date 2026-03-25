package za.ac.cput.factory;

import za.ac.cput.domain.Role;
import za.ac.cput.util.HelperUtil;

/*
    RoleFactory.java
    Role factory class
    Author: Charlton Solomons (220483418)
    Date: 19 March 2026
*/

public class RoleFactory {

    public static Role createRole(String roleName, String description) {
        Long roleId = HelperUtil.generateId();

        if (HelperUtil.isNullOrEmpty(roleName) || HelperUtil.isNullOrEmpty(roleName)) {
            return null;
        }

        return new Role.Builder()
                .setRoleId(roleId)
                .setRoleName(roleName)
                .setDescription(description)
                .build();
    }

}
