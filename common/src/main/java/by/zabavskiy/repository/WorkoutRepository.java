package by.zabavskiy.repository;

import by.zabavskiy.domain.Workout;

import java.util.List;

public interface WorkoutRepository {
    List<Workout> findUserWorkouts(Long userId);
}