package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Role;
import by.zabavskiy.repository.RoleRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private static final Logger log = Logger.getLogger(RoleRepositoryImpl.class);

    @Override
    public List<Role> findUserRoles(Long userId) {
        return Collections.emptyList();
    }
}
