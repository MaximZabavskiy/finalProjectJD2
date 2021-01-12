package by.zabavskiy.controller.convert;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.CurrentStatus;
import by.zabavskiy.domain.Role;
import by.zabavskiy.domain.User;
import by.zabavskiy.domain.enums.SystemRoles;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class UserCreateRequestConverter extends UserEntityConverter<UserCreateRequest, User> {

    public UserCreateRequestConverter(PasswordEncoder passwordEncoder) {
        super(passwordEncoder);
    }

    @Override
    public User convert(UserCreateRequest request) {

        User user = new User();
        user.setCreated(new Timestamp(new Date().getTime()));
        user.setChanged(new Timestamp(new Date().getTime()));

        Role role = new Role();
        role.setRoleName(SystemRoles.ROLE_USER);
        role.setCreated(new Timestamp(new Date().getTime()));
        role.setChanged(new Timestamp(new Date().getTime()));
        role.setUser(user);
        user.setRole(role);

        CurrentStatus currentStatus = new CurrentStatus();
        currentStatus.setBlocked(false);
        user.setCurrentStatus(currentStatus);
        role.setCurrentStatus(currentStatus);

        return doConvert(user, request);
    }
}
