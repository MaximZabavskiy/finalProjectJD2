package by.zabavskiy.repository;

import by.zabavskiy.domain.Calendar;

import java.util.List;


public interface CalendarRepository {
    List<Calendar> findUserCalendar(Long userId);
}