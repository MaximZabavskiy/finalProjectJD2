package by.zabavskiy.controller.convert;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.Role;
import by.zabavskiy.domain.User;
import by.zabavskiy.domain.enums.SystemRoles;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class UserCreateRequestConverter extends EntityConverter<UserCreateRequest, User> {

    @Override
    public User convert(UserCreateRequest request) {

        User user = new User();
        user.setCreated(new Timestamp(new Date().getTime()));
        user.setChanged(new Timestamp(new Date().getTime()));

        Role Role = new Role();
        Role.setRoleName(SystemRoles.ROLE_USER);
        Role.setUser(user);
        user.setRole(Role);

        return doConvert(user, request);
    }
}
