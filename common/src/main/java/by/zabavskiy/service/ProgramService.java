package by.zabavskiy.service;

import by.zabavskiy.domain.Program;

import java.util.List;

public interface ProgramService {

    List<Program> findAll();

    List<Program> findAllWithCache();

    Program findById(Long programId);

    Program save(Program program);

    Program update(Program program);

    void deleteById(Long id);
}
