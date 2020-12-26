package by.zabavskiy.repository;

import by.zabavskiy.domain.Program;

import java.util.List;

public interface ProgramRepository {
    List<Program> findUserPrograms(Long userId);
}