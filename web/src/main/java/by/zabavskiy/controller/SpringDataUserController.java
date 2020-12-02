package by.zabavskiy.controller;

import com.htp.config.ProfilesTestCheckConfig;
import com.htp.controller.request.UserCreateRequest;
import com.htp.dao.springdata.UserRepository;
import com.htp.domain.hibernate.HibernateUser;
import io.swagger.annotations.*;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/springdata/users")
@Transactional
public class SpringDataUserController {

    private UserRepository userRepository;

    private ConversionService conversionService;

    private ProfilesTestCheckConfig testCheckConfig;

    public SpringDataUserController(UserRepository userRepository,
                                    ConversionService conversionService,
                                    ProfilesTestCheckConfig testCheckConfig) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
        this.testCheckConfig = testCheckConfig;
    }

    @ApiOperation(value = "Finding all users")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful loading users"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @GetMapping
    public ResponseEntity<List<HibernateUser>> findAll() {
        return new ResponseEntity<>(userRepository.findUsersWithAdminRoles(), HttpStatus.OK);
    }

    @ApiOperation(value = "Search with pagination")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful loading users"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "Page number", example = "0", defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Items per page", example = "3", defaultValue = "3", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "Field to sort", example = "0", defaultValue = "id", dataType = "string", paramType = "query")
    })
    @GetMapping("/search")
    public ResponseEntity<Page<HibernateUser>> searchWithPagination(@ApiIgnore Pageable pageable) {
        Page<HibernateUser> usersPage = userRepository.findAll(pageable);
        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }

    @ApiOperation(value = "Test profile")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful loading users"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @GetMapping("/testProfile")
    public ResponseEntity<String> testProfile() {

        return new ResponseEntity<>(testCheckConfig.getProfileName(), HttpStatus.OK);
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
        return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);
    }

    @ApiOperation(value = "Create user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful creation user"),
            @ApiResponse(code = 422, message = "Failed user creation properties validation"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @PostMapping
    public HibernateUser create(@Valid @RequestBody UserCreateRequest createRequest) throws SQLException {

        HibernateUser user = conversionService.convert(createRequest, HibernateUser.class);

        return userRepository.save(user);
    }
}
