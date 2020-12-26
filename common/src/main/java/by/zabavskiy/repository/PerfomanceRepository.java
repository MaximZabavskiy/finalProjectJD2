package by.zabavskiy.repository;

import by.zabavskiy.domain.Perfomance;

import java.util.List;



public interface PerfomanceRepository {
    List<Perfomance> findUserPerfomance(Long userId);
}