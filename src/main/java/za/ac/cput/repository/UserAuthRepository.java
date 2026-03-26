package za.ac.cput.repository;

import za.ac.cput.domain.UserAuth;

import java.util.HashMap;
import java.util.Map;

/**
 * UserAuthRepository.java
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 26 March 2026
 */

public class UserAuthRepository implements IRepositry<UserAuth, Long> {

    private static UserAuthRepository repository = null;
    private Map<Long, UserAuth> userAuthMap;

    private UserAuthRepository() {
        userAuthMap = new HashMap<>();
    }

    public static UserAuthRepository getRepository() {
        if (repository == null) {
            repository = new UserAuthRepository();
        }
        return repository;
    }

    @Override
    public UserAuth create(UserAuth userAuth) {
        userAuthMap.put(userAuth.getAuthId(), userAuth);
        return userAuth;
    }

    @Override
    public UserAuth read(Long authId) {
        return userAuthMap.get(authId);
    }

    @Override
    public UserAuth update(UserAuth userAuth) {
        if (userAuthMap.containsKey(userAuth.getAuthId())) {
            userAuthMap.put(userAuth.getAuthId(), userAuth);
            return userAuth;
        }
        return null;
    }


    @Override
    public boolean delete(Long authId) {
        return userAuthMap.remove(authId) != null;
    }
}
