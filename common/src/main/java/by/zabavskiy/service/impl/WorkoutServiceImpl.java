package by.zabavskiy.service.impl;

import by.zabavskiy.domain.Workout;
import by.zabavskiy.repository.impl.WorkoutSpringDataRepository;
import by.zabavskiy.service.WorkoutService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private WorkoutSpringDataRepository workoutSpringDataRepository;

    public WorkoutServiceImpl(WorkoutSpringDataRepository workoutSpringDataRepository) {
        this.workoutSpringDataRepository = workoutSpringDataRepository;
    }

    @Override
    public List<Workout> findAll() {
        return workoutSpringDataRepository.findAllWithCache();
    }
}
