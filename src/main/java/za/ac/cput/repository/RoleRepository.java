package za.ac.cput.repository;

import za.ac.cput.domain.Role;

import java.util.HashMap;
import java.util.Map;

public class RoleRepository implements IRepository<Role, Long> {

    private static RoleRepository repository = null;
    private Map<Long, Role> roleMap;

    private RoleRepository() {
        roleMap = new HashMap<>();
    }

    public static RoleRepository getRepository() {
        if (repository == null) {
            repository = new RoleRepository();
        }
        return repository;
    }

    @Override
    public Role create(Role role) {
        roleMap.put(role.getRoleId(), role);
        return role;
    }

    @Override
    public Role read(Long roleId) {
        return roleMap.get(roleId);
    }

    @Override
    public Role update(Role role) {
        if (roleMap.containsKey(role.getRoleId())) {
            roleMap.put(role.getRoleId(), role);
            return role;
        }
        return null;
    }

    @Override
    public boolean delete(Long roleId) {
        return roleMap.remove(roleId) != null;
    }

    public void clear() {
        roleMap.clear();
    }
}