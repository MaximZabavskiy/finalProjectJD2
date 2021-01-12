package by.zabavskiy.security.controller;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.User;
import by.zabavskiy.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    public final ConversionService conversionService;

    @ApiOperation(value = "Endpoint for registration users by params")
    @PostMapping
    public ResponseEntity<Map<String, Object>> registration(@Valid @RequestBody UserCreateRequest userCreateRequest) {

        User user = conversionService.convert(userCreateRequest, User.class);

        User savedUser = userService.save(user);


        Map<String, Object> result = new HashMap<>();

        result.put("id", savedUser.getId());
        result.put("login", savedUser.getLogin());

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
