package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Workout;
import by.zabavskiy.repository.WorkoutRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Primary
@Log4j2
public class WorkoutRepositoryImpl implements WorkoutRepository {

    private SessionFactory sessionFactory;

    public WorkoutRepositoryImpl(SessionFactory sessionFactory/*, EntityManager entityManager*/) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Workout> findUserWorkouts(Long userId) {
        return Collections.emptyList();
    }
}
