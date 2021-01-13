package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Program;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface ProgramSpringDataRepository extends JpaRepository<Program, Long> {

    @Cacheable("programs")
    @Query(value = "select p from Program p")
    List<Program> findAllWithCache();

    @Query(value = "select p from Program p order by p.id")
    List<Program> findAllPrograms();

    @Query(value = "select p from Program p where p.id = :id ")
    Program findProgramById(@Param("id") Long id);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = SQLException.class)
    @Modifying
    @Query(value = "delete from m_programs where id = :id", nativeQuery = true)
    int deleteProgramById(@Param("id") Long id);
}
