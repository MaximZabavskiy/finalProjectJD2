package by.zabavskiy.controller;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.controller.request.UserEditRequest;
import by.zabavskiy.domain.User;
import by.zabavskiy.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    public final ConversionService conversionService;

    @ApiOperation(value = "Endpoint \"Creation of users\"")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Auth-Token", defaultValue = "token", required = true, paramType = "header", dataType = "string"),
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful creation user"),
            @ApiResponse(code = 422, message = "Failed user creation properties validation"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {

        User user = conversionService.convert(userCreateRequest, User.class);

        return userService.save(user);
    }


    @ApiOperation(value = "Endpoint \"All user's search\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Auth-Token", defaultValue = "token", required = true, paramType = "header", dataType = "string"),
    })
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }


    @ApiOperation(value = "Endpoint \"User's search by id\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }


    @ApiOperation(value = "Endpoint \"User's update\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody UserEditRequest userEditRequest) {

        User user = conversionService.convert(userEditRequest, User.class);

        return userService.update(user);
    }


    @ApiOperation(value = "Endpoint \"User's deletion\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @PutMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {

        userService.deleteById(id);
    }


    @ApiOperation(value = "Endpoint \"User's search by params\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @GetMapping("/search")
    public ResponseEntity<User> search(@RequestParam String gender, @RequestParam String firstName, String surname, @RequestParam String login, Long id, Date birthDate, Timestamp created, Timestamp changed) {
        return new ResponseEntity<>(userService.search(gender, firstName, surname, login, id, birthDate, created, changed), HttpStatus.OK);
    }
}