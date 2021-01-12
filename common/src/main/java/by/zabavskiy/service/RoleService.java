package by.zabavskiy.service;

import by.zabavskiy.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    List<Role> findUserRoles(Long userId);
}
