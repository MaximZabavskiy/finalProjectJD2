package by.zabavskiy.security.controller;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.CurrentStatus;
import by.zabavskiy.domain.User;
import by.zabavskiy.repository.impl.UserSpringDataRepository;
import by.zabavskiy.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    private final UserSpringDataRepository userSpringDataRepository;



    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "Endpoint for registration users by 6 params")
    @PostMapping
    public ResponseEntity<Map<String, Object>> registration(@RequestBody UserCreateRequest userCreateRequest) {
        //converters
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

        User savedUser = userSpringDataRepository.save(user);

        Map<String, Object> result = new HashMap<>();

        result.put("id", savedUser.getId());
        result.put("login", savedUser.getLogin());

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
