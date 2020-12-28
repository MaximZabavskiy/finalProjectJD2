package by.zabavskiy.controller;

import by.zabavskiy.domain.Program;
import by.zabavskiy.domain.Role;
import by.zabavskiy.service.ProgramService;
import by.zabavskiy.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final CacheManager cacheManager;

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/caches")
    public ResponseEntity<Object> getCachesInfo() {
        return new ResponseEntity<>(String.join(",", cacheManager.getCacheNames()), HttpStatus.OK);
    }
}