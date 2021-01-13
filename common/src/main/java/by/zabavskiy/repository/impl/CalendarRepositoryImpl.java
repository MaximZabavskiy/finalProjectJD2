package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Calendar;
import by.zabavskiy.repository.CalendarRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
@Primary
@Log4j2
public class CalendarRepositoryImpl implements CalendarRepository {

    private SessionFactory sessionFactory;

    public CalendarRepositoryImpl(SessionFactory sessionFactory/*, EntityManager entityManager*/) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Calendar> findUserCalendar(Long userId) {
        return Collections.emptyList();
    }
}