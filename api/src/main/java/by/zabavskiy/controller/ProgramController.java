package by.zabavskiy.controller;

import by.zabavskiy.domain.Program;
import by.zabavskiy.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;
    private final CacheManager cacheManager;

    @GetMapping
    public ResponseEntity<List<Program>> findAll() {
        return new ResponseEntity<>(programService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/caches")
    public ResponseEntity<Object> getCachesInfo() {
        return new ResponseEntity<>(String.join(",", cacheManager.getCacheNames()), HttpStatus.OK);
    }
}
