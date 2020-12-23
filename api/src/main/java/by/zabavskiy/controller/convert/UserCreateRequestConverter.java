package by.zabavskiy.controller.convert;



import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.User;
import by.zabavskiy.domain.enums.SystemRoles;
import by.zabavskiy.domain.Role;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;

//@Component
//public class UserCreateRequestConverter extends UserRequestConverter<UserCreateRequest, User> {
//
//    @Override
//    public User convert(UserCreateRequest request) {
//
//        User user = new User();
//
////        TimedEntity timedEntity = new TimedEntity();
////        timedEntity.setCreated(new Timestamp(new Date().getTime()));
////        timedEntity.setChanged(new Timestamp(new Date().getTime()));
////        user.setProfileUpdates(timedEntity);
//
//        Role role = new Role();
//        role.setRoleName(SystemRoles.ROLE_USER.name());
//        role.setUser(user);
//        user.setRole(role);
//
//        return doConvert(user, request);
//    }
//}
