package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Program;
import by.zabavskiy.repository.ProgramRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProgramRepositoryImpl implements ProgramRepository {

    private static final Logger log = Logger.getLogger(ProgramRepositoryImpl.class);

    @Override
    public List<Program> findUserPrograms(Long userId) {
        return Collections.emptyList();
    }
}