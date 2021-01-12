package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Role;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleSpringDataRepository extends JpaRepository<Role, Long> {

    @Cacheable("roles")
    @Query(value = "select r from Role r")
    List<Role> findAllWithCache();
}
