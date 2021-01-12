package by.zabavskiy.controller;

import by.zabavskiy.domain.Role;
import by.zabavskiy.service.RoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    private final CacheManager cacheManager;

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {

        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }


    @ApiOperation(value = "Endpoint \"Cache's information\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @GetMapping("/caches")
    public ResponseEntity<Object> getCachesInfo() {

        return new ResponseEntity<>(String.join(",", cacheManager.getCacheNames()), HttpStatus.OK);
    }
}