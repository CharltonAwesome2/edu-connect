package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * UserRepository.java
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 26 March 2026
 */

public class UserRepository implements IRepository<User, Long>{

    private static UserRepository repository = null;
    private Map<Long, User> userMap;

    private UserRepository() {
        userMap = new HashMap<>();
    }

    public static UserRepository getRepository() {
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }

    @Override
    public User create(User user) {
        userMap.put(user.getUserId(), user);
        return user;
    }

    @Override
    public User read(Long userId) {
        return userMap.get(userId);
    }

    @Override
    public User update(User user) {
        if (userMap.containsKey(user.getUserId())) {
            userMap.put(user.getUserId(), user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(Long userId) {
        return userMap.remove(userId) != null;
    }
}
