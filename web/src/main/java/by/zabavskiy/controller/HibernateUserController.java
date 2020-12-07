package by.zabavskiy.controller;


import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.daorepository.HibernateUserDao;
import by.zabavskiy.domain.enums.*;
import by.zabavskiy.domain.hibernate.HibernateRole;
import by.zabavskiy.domain.hibernate.HibernateUser;
import by.zabavskiy.domain.hibernate.TimedEntity;
import by.zabavskiy.service.HibUserService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/hibernate/users")
@Transactional
public class HibernateUserController {

    private HibUserService hibernateUserService;

    private HibernateUserDao hibernateUserRepository;

    public HibernateUserController(HibUserService hibernateUserService,
                                   HibernateUserDao hibernateUserRepository) {
        this.hibernateUserService = hibernateUserService;
        this.hibernateUserRepository = hibernateUserRepository;
    }

    @ApiOperation(value = "Finding all users")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful loading users"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @GetMapping
    public ResponseEntity<List<HibernateUser>> findAll() {
        return new ResponseEntity<>(hibernateUserService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Test caches")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful loading users"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @GetMapping("/testCache")
    public ResponseEntity<String> testCaches() {
        hibernateUserRepository.testFirstLevelCache();

        return new ResponseEntity<>("so far so good!", HttpStatus.OK);
    }

    @ApiOperation(value = "Finding user by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful loading user"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "User database id", example = "7", required = true, dataType = "long", paramType = "path")
    })
    @GetMapping("/{id}")
    public ResponseEntity<HibernateUser> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(hibernateUserService.findOne(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful creation user"),
            @ApiResponse(code = 422, message = "Failed user creation properties validation"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @PostMapping
    public HibernateUser create(@Valid @RequestBody UserCreateRequest createRequest) throws SQLException {

        HibernateUser user = new HibernateUser();

        user.setName(createRequest.getName());
        user.setSurname(createRequest.getSurname());
        user.setUsername(createRequest.getUsername());
        user.setPassword(createRequest.getPassword());
        user.setEmail(createRequest.getEmail());
        user.setGender(createRequest.getGender());
        user.setBirthDate(createRequest.getBirthDate());
        user.setHeight(createRequest.getHeight());
        user.setWeight(createRequest.getWeight());
        user.setFitnessLevel(createRequest.getFitnessLevel());
        user.setGoalName(createRequest.getGoalName());
        user.setStatus(createRequest.getStatus());

        TimedEntity timedEntity = new TimedEntity();
        timedEntity.setCreated(new Timestamp(new Date().getTime()));
        timedEntity.setChanged(new Timestamp(new Date().getTime()));
        user.setProfileUpdates(timedEntity);

        HibernateRole hibernateRole = new HibernateRole();
        hibernateRole.setRoleName(SystemRoles.ROLE_USER.name());
        hibernateRole.setUser(user);
        user.setRoles(Collections.singleton(hibernateRole));

        return hibernateUserService.save(user);
    }
}
