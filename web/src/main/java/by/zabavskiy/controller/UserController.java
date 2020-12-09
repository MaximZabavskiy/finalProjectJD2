package by.zabavskiy.controller;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.User;
import by.zabavskiy.service.UserService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Finding all users")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful loading users"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
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
    public User findById(@PathVariable("id") Long userId) {
        return userService.findOne(userId);
    }

    @ApiOperation(value = "Search users by login")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful loading user"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "Search query - free text", example = "viachaslauk", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/search")
    public List<User> searchUser(@RequestParam("query") String query) {
        return userService.search(query);
    }

    @ApiOperation(value = "Create user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful creation user"),
            @ApiResponse(code = 422, message = "Failed user creation properties validation"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @PostMapping
    public User create(@Valid @RequestBody UserCreateRequest createRequest) {

        User user = new User();
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

        return userService.save(user);
    }

//    @GetMapping
//    public String findAll(ModelMap modelMap) {
//        modelMap.addAttribute("users", userService.findAll());
//        return "user/users";
//    }
//
//    @GetMapping("/{id}")
//    public String findById(@PathVariable("id") Long userId, ModelMap modelMap) {
//        modelMap.addAttribute("user", userService.findOne(userId));
//        return "user/user";
//    }
//
//    @GetMapping("/search")
//    public String searchUser(@RequestParam("query") String query, ModelMap modelMap) {
//        modelMap.addAttribute("users", userService.search(query));
//        return "user/users";
//    }
}
