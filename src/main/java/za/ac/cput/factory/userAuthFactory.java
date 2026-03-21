package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

/**
 * userAuthFactory.java
 * Factory class for creating UserAuth objects
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 21 March 2026
 */

public class userAuthFactory {
    public static UserAuth createUserAuth(String password, User user) {
        
        if (!HelperUtil.isNullorEmpty(password)) {
            return null;
        }

        if (user == null) {
            return null;
        }

        String hashedPassword = HelperUtil.hashPassword(password);
        String salt = HelperUtil.extractSalt(hashedPassword);

        return new UserAuth.Builder()
                .setAuthId(HelperUtil.generateId())
                .passwordHash(hashedPassword)
                .setSalt(salt)
                .setCreatedAt(LocalDateTime.now())
                .setUser(user)
                .build();
    }
}
