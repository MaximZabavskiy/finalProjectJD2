package by.zabavskiy.service.impl;

import by.zabavskiy.domain.Calendar;
import by.zabavskiy.repository.impl.CalendarSpringDataRepository;
import by.zabavskiy.service.CalendarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    private CalendarSpringDataRepository calendarSpringDataRepository;

    public CalendarServiceImpl(CalendarSpringDataRepository calendarSpringDataRepository) {
        this.calendarSpringDataRepository = calendarSpringDataRepository;
    }

    @Override
    public List<Calendar> findAll() {
        return calendarSpringDataRepository.findAllWithCache();
    }
}