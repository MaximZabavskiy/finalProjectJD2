package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Calendar;
import by.zabavskiy.domain.Program;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CalendarSpringDataRepository extends JpaRepository<Calendar, Long> {

    @Cacheable("calendar")
    @Query(value = "select c from Calendar c")
    List<Calendar> findAllWithCache();
}
