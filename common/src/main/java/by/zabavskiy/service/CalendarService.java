package by.zabavskiy.service;

import by.zabavskiy.domain.Calendar;
import by.zabavskiy.domain.Program;

import java.util.List;

public interface CalendarService {

    List<Calendar> findAll();
}
