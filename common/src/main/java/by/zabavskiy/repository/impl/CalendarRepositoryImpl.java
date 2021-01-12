package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Calendar;
import by.zabavskiy.repository.CalendarRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
public class CalendarRepositoryImpl implements CalendarRepository {

    private static final Logger log = Logger.getLogger(CalendarRepositoryImpl.class);

    @Override
    public List<Calendar> findUserCalendar(Long userId) {
        return Collections.emptyList();
    }
}