package by.zabavskiy.repository;

import by.zabavskiy.domain.Role;

import java.util.List;

public interface RoleRepository extends CrudRepository<Long, Role> {
    List<Role> findUserRoles(Long userId);
}
