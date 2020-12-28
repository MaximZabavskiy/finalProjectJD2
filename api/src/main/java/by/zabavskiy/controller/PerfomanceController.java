package by.zabavskiy.controller;

import by.zabavskiy.domain.Equipment;
import by.zabavskiy.domain.Perfomance;
import by.zabavskiy.service.EquipmentService;
import by.zabavskiy.service.PerfomanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/perfomance")
@RequiredArgsConstructor
public class PerfomanceController {

    private final PerfomanceService perfomanceService;
    private final CacheManager cacheManager;

    @GetMapping
    public ResponseEntity<List<Perfomance>> findAll() {
        return new ResponseEntity<>(perfomanceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/caches")
    public ResponseEntity<Object> getCachesInfo() {
        return new ResponseEntity<>(String.join(",", cacheManager.getCacheNames()), HttpStatus.OK);
    }
}