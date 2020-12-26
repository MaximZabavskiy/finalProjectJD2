package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Perfomance;
import by.zabavskiy.domain.Program;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerfomanceSpringDataRepository extends JpaRepository<Perfomance, Long> {

    @Cacheable("perfomance")
    @Query(value = "select p from Perfomance p")
    List<Perfomance> findAllWithCache();
}
