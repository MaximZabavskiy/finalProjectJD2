package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Workout;
import by.zabavskiy.repository.WorkoutRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class WorkoutRepositoryImpl implements WorkoutRepository {

    private static final Logger log = Logger.getLogger(WorkoutRepositoryImpl.class);

    @Override
    public List<Workout> findUserWorkouts(Long userId) {
        return Collections.emptyList();
    }
}
