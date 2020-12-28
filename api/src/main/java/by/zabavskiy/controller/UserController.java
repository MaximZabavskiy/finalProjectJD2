package by.zabavskiy.controller;

import by.zabavskiy.controller.request.UserChangeRequest;
import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.CurrentStatus;
import by.zabavskiy.domain.Role;
import by.zabavskiy.domain.User;
import by.zabavskiy.domain.enums.SystemRoles;
import by.zabavskiy.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Endpoint for creation users")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Auth-Token", defaultValue = "token", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "query", defaultValue = "query", required = false, paramType = "path", dataType = "string")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserCreateRequest userCreateRequest) {

        User user = new User();

        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setLogin(userCreateRequest.getLogin());
        user.setPassword(userCreateRequest.getPassword());
        user.setEmail(userCreateRequest.getEmail());
        user.setGender(userCreateRequest.getGender());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setHeight(userCreateRequest.getHeight());
        user.setWeight(userCreateRequest.getWeight());
        user.setFitnessLevel(userCreateRequest.getFitnessLevel());
        user.setGoal(userCreateRequest.getGoal());
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setCurrentStatus(new CurrentStatus(userCreateRequest.getIsBlocked()));


        user.setRole(new Role(SystemRoles.ROLE_ADMIN, user));
        return userService.save(user);
    }

    @GetMapping("/search")
    public ResponseEntity<User> search(@RequestParam String gender, @RequestParam String firstName, String surname, @RequestParam String login, Long id, Date birthDate, Timestamp created, Timestamp changed) {
        return new ResponseEntity<>(userService.search(gender, firstName, surname, login, id, birthDate, created, changed), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable Long id,
                           @RequestBody UserCreateRequest userCreateRequest) {

        User user = userService.findById(id);

        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setLogin(userCreateRequest.getLogin());
        user.setPassword(userCreateRequest.getPassword());
        user.setEmail(userCreateRequest.getEmail());
        user.setGender(userCreateRequest.getGender());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setHeight(userCreateRequest.getHeight());
        user.setWeight(userCreateRequest.getWeight());
        user.setFitnessLevel(userCreateRequest.getFitnessLevel());
        user.setGoal(userCreateRequest.getGoal());
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setCurrentStatus(new CurrentStatus(userCreateRequest.getIsBlocked()));

        user.setRole(new Role(SystemRoles.ROLE_ADMIN, user));
        return userService.update(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody UserChangeRequest userChangeRequest) {

        User user = userService.findById(userChangeRequest.getId());

        user.setName(userChangeRequest.getName());
        user.setSurname(userChangeRequest.getSurname());
        user.setLogin(userChangeRequest.getLogin());
        user.setPassword(userChangeRequest.getPassword());
        user.setEmail(userChangeRequest.getEmail());
        user.setGender(userChangeRequest.getGender());
        user.setBirthDate(userChangeRequest.getBirthDate());
        user.setHeight(userChangeRequest.getHeight());
        user.setWeight(userChangeRequest.getWeight());
        user.setFitnessLevel(userChangeRequest.getFitnessLevel());
        user.setGoal(userChangeRequest.getGoal());
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setCurrentStatus(new CurrentStatus(userChangeRequest.getIsBlocked()));

        return userService.update(user);
    }

    @PutMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @PutMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }


    /*
    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<User> all = userService.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> findUserByLogin(@RequestParam String login) {
        Optional<User> user = userService.findByLogin(login);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


//    @GetMapping("/search")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<User> findUserWithFunctionCall() {
//        return new ResponseEntity<User>(userService.findUserWithFunctionCall(Gender.MALE.name(), "Slava", "qweqweqwe", "loginSlava", null, null, null, null), HttpStatus.OK);
//    }

//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
//                    value = "Results page you want to retrieve (0..N)"),
//            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
//                    value = "Number of records per page."),
//            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
//                    value = "Sorting criteria in the format: property(,asc|desc). " +
//                            "Default sort order is ascending. " +
//                            "Multiple sort criteria are supported.")
//    })
//    @GetMapping("/all")
//    public ResponseEntity<Page<User>> getUsersSpringData(@ApiIgnore Pageable pageable) {
//        return new ResponseEntity<Page<User>>(userService.findAll(pageable)), HttpStatus.OK);
//    }


    @PostMapping("/modifying")
    public ResponseEntity<Object> testCreatingLinkRow() {
        return new ResponseEntity<>(userService.testCreatingLinkRow(46L, 3L), HttpStatus.CREATED);
    }



//    @GetMapping("/search")
//    @ResponseStatus(HttpStatus.OK)
//    public User search(@RequestParam String gender, @RequestParam String firstName, @RequestParam String surname, @RequestParam String login, @RequestParam Long id, @RequestParam Date birthDate, @RequestParam Timestamp created, @RequestParam Timestamp changed) {
//        return new User(userService.search(gender, firstName, surname, login, id, birthDate, created, changed));
//    }

    @ApiOperation(value = "Endpoint for creation users")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Auth-Token", defaultValue = "token", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "query", defaultValue = "query", required = false, paramType = "path", dataType = "string")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User savingUser(@RequestBody UserCreateRequest userCreateRequest) {
        //converters
        User user = new User();
        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setCredentials(new CurrentStatus(userCreateRequest.getLogin(),
                userCreateRequest.getPassword()));
        user.setEmail(userCreateRequest.getEmail());
        user.setGender(userCreateRequest.getGender());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setHeight(userCreateRequest.getHeight());
        user.setWeight(userCreateRequest.getWeight());
        user.setFitnessLevel(userCreateRequest.getFitnessLevel());
        user.setGoalName(userCreateRequest.getGoalName());
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setBlocked(userCreateRequest.getIsBlocked());



//        user.setRoles(Collections.singleton(new Role(SystemRoles.ROLE_ADMIN, user)));
        user.setRole(new Role(SystemRoles.ROLE_ADMIN, user));
        return userService.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable Long id,
                                    @RequestBody UserCreateRequest userCreateRequest) {

        User user = userService.findById(id);

        //converters
        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setCredentials(new CurrentStatus(userCreateRequest.getLogin(),
                userCreateRequest.getPassword()));
        user.setEmail(userCreateRequest.getEmail());
        user.setGender(userCreateRequest.getGender());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setHeight(userCreateRequest.getHeight());
        user.setWeight(userCreateRequest.getWeight());
        user.setFitnessLevel(userCreateRequest.getFitnessLevel());
        user.setGoalName(userCreateRequest.getGoalName());
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setBlocked(userCreateRequest.getIsBlocked());

        //user.setRoles(Collections.singleton(new HibernateRole("ROLE_ADMIN", user)));
        user.setRole(new Role(SystemRoles.ROLE_ADMIN, user));
        return userService.update(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody UserChangeRequest userChangeRequest) {

        User user = userService.findById(userChangeRequest.getId());

        //converters
        user.setName(userChangeRequest.getName());
        user.setSurname(userChangeRequest.getSurname());
        user.setCredentials(new CurrentStatus(userChangeRequest.getLogin(),
                userChangeRequest.getPassword()));
        user.setEmail(userChangeRequest.getEmail());
        user.setGender(userChangeRequest.getGender());
        user.setBirthDate(userChangeRequest.getBirthDate());
        user.setHeight(userChangeRequest.getHeight());
        user.setWeight(userChangeRequest.getWeight());
        user.setFitnessLevel(userChangeRequest.getFitnessLevel());
        user.setGoalName(userChangeRequest.getGoalName());
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setBlocked(userChangeRequest.getIsBlocked());


        return userService.update(user);
    }
*/
}