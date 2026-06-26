package za.ac.cput.repository;

import za.ac.cput.domain.UserRole;

import java.util.HashMap;
import java.util.Map;

public class UserRoleRepository implements IRepository<UserRole, Long> {

    private static UserRoleRepository repository = null;
    private Map<Long, UserRole> userRoleMap;

    private UserRoleRepository() {
        userRoleMap = new HashMap<>();
    }

    public static UserRoleRepository getRepository() {
        if (repository == null) {
            repository = new UserRoleRepository();
        }
        return repository;
    }

    @Override
    public UserRole create(UserRole userRole) {
        userRoleMap.put(userRole.getUserRoleId(), userRole);
        return userRole;
    }

    @Override
    public UserRole read(Long userRoleId) {
        return userRoleMap.get(userRoleId);
    }

    @Override
    public UserRole update(UserRole userRole) {
        if (userRoleMap.containsKey(userRole.getUserRoleId())) {
            userRoleMap.put(userRole.getUserRoleId(), userRole);
            return userRole;
        }
        return null;
    }

    @Override
    public boolean delete(Long userRoleId) {
        return userRoleMap.remove(userRoleId) != null;
    }

    public void clear() {
        userRoleMap.clear();
    }
}