package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Workout;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutSpringDataRepository extends JpaRepository<Workout, Long> {

    @Cacheable("workouts")
    @Query(value = "select w from Workout w")
    List<Workout> findAllWithCache();
}
