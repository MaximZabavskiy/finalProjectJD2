package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Role;
import by.zabavskiy.repository.RoleRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Primary
@Log4j2
public class RoleRepositoryImpl implements RoleRepository {

    private SessionFactory sessionFactory;

    public RoleRepositoryImpl(SessionFactory sessionFactory/*, EntityManager entityManager*/) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Role> findUserRoles(Long userId) {
        return Collections.emptyList();
    }
}
