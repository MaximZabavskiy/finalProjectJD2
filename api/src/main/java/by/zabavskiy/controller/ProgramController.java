package by.zabavskiy.controller;

import by.zabavskiy.controller.request.ProgramCreateRequest;
import by.zabavskiy.controller.request.ProgramEditRequest;
import by.zabavskiy.domain.CurrentStatus;
import by.zabavskiy.domain.Program;
import by.zabavskiy.domain.User;
import by.zabavskiy.service.ProgramService;
import by.zabavskiy.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/rest/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

    private final CacheManager cacheManager;

    private final UserService userService;


    @ApiOperation(value = "Endpoint \"All program's search\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Auth-Token", defaultValue = "token", required = true, paramType = "header", dataType = "string"),
    })
    @GetMapping
    public ResponseEntity<List<Program>> findAllPrograms() {

        return new ResponseEntity<>(programService.findAll(), HttpStatus.OK);
    }


    @ApiOperation(value = "Endpoint \"Program's search by id\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @GetMapping("/{id}")
    public ResponseEntity<Program> findProgramById(@PathVariable Long id) {

        return new ResponseEntity<>(programService.findById(id), HttpStatus.OK);
    }


    @ApiOperation(value = "Endpoint \"Program's creation\"")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Program createProgram(@RequestBody ProgramCreateRequest programCreateRequest) {

        User user = userService.findById(programCreateRequest.getUserId());
        Program program = new Program();
        program.setName(programCreateRequest.getName());
        program.setDifficulty(programCreateRequest.getDifficulty());
        program.setDuration(programCreateRequest.getDuration());
        program.setType(programCreateRequest.getType());
        program.setCreated(new java.sql.Timestamp(new Date().getTime()));
        program.setChanged(new java.sql.Timestamp(new Date().getTime()));
        program.setUser(user);

        CurrentStatus currentStatus = new CurrentStatus();
        currentStatus.setBlocked(false);
        program.setCurrentStatus(currentStatus);

        return programService.save(program);
    }


    @ApiOperation(value = "Endpoint \"Program's update\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Program updateProgram(@RequestBody ProgramEditRequest programEditRequest) {

        User user = userService.findById(programEditRequest.getUserId());
        Program program = programService.findById(programEditRequest.getId());
        program.setName(programEditRequest.getName());
        program.setDifficulty(programEditRequest.getDifficulty());
        program.setDuration(programEditRequest.getDuration());
        program.setType(programEditRequest.getType());
        program.setChanged(new java.sql.Timestamp(new Date().getTime()));
        program.setUser(user);

        return programService.save(program);
    }


    @ApiOperation(value = "Endpoint \"Programs's deletion\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @PutMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {

        programService.deleteById(id);
    }


    @ApiOperation(value = "Endpoint \"Program's caches info\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @GetMapping("/caches")
    public ResponseEntity<Object> getCachesInfo() {

        return new ResponseEntity<>(String.join(",", cacheManager.getCacheNames()), HttpStatus.OK);
    }
}
