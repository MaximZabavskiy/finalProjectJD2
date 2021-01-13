package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Program;
import by.zabavskiy.repository.ProgramRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Primary
@Log4j2
public class ProgramRepositoryImpl implements ProgramRepository {

    private SessionFactory sessionFactory;

    public ProgramRepositoryImpl(SessionFactory sessionFactory/*, EntityManager entityManager*/) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Program> findUserPrograms(Long userId) {
        return Collections.emptyList();
    }
}