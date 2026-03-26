package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

/**
 * userFactory.java
 * Factory class for creating User objects2
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 21 March 2026
 */

public class userFactory {
    public static User createUser(String name, String surname, String studentNumber,
                                  String email, String contactNumber) {
        
        if (!HelperUtil.isNullOrEmpty(name) || !HelperUtil.isNullOrEmpty(surname) ||
            !HelperUtil.isNullOrEmpty(studentNumber)) {
            return null;
        }

        if (!HelperUtil.isValidEmail(email)) {
            return null;
        }

        return new User.Builder()
                .setUserId(HelperUtil.generateId())
                .setName(name)
                .setSurname(surname)
                .setStudentNumber(studentNumber)
                .setEmail(email)
                .setContactNumber(contactNumber)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }
}
