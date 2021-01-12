package by.zabavskiy.service.impl;

import by.zabavskiy.domain.Role;
import by.zabavskiy.repository.RoleRepository;
import by.zabavskiy.repository.impl.RoleSpringDataRepository;
import by.zabavskiy.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleSpringDataRepository roleSpringDataRepository;
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleSpringDataRepository roleSpringDataRepository) {
        this.roleSpringDataRepository = roleSpringDataRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleSpringDataRepository.findAllWithCache();
    }

    @Override
    public List<Role> findUserRoles(Long userId) {
        return roleSpringDataRepository.findAllById(Collections.singleton(userId)); // changed
    }
}
