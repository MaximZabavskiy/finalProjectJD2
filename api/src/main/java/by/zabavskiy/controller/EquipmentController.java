package by.zabavskiy.controller;

import by.zabavskiy.domain.Calendar;
import by.zabavskiy.domain.Equipment;
import by.zabavskiy.service.CalendarService;
import by.zabavskiy.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final CacheManager cacheManager;

    @GetMapping
    public ResponseEntity<List<Equipment>> findAll() {
        return new ResponseEntity<>(equipmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/caches")
    public ResponseEntity<Object> getCachesInfo() {
        return new ResponseEntity<>(String.join(",", cacheManager.getCacheNames()), HttpStatus.OK);
    }
}