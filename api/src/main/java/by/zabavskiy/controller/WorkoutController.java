package by.zabavskiy.controller;

import by.zabavskiy.domain.Role;
import by.zabavskiy.domain.Workout;
import by.zabavskiy.service.RoleService;
import by.zabavskiy.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;
    private final CacheManager cacheManager;

    @GetMapping
    public ResponseEntity<List<Workout>> findAll() {
        return new ResponseEntity<>(workoutService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/caches")
    public ResponseEntity<Object> getCachesInfo() {
        return new ResponseEntity<>(String.join(",", cacheManager.getCacheNames()), HttpStatus.OK);
    }
}