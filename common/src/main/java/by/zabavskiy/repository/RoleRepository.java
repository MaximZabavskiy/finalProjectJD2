package by.zabavskiy.repository;


import by.zabavskiy.domain.Role;

import java.util.List;

public interface RoleRepository {
    List<Role> findUserRoles(Long userId);
}
