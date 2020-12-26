package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Program;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramSpringDataRepository extends JpaRepository<Program, Long> {

    @Cacheable("programs")
    @Query(value = "select p from Program p")
    List<Program> findAllWithCache();
}
