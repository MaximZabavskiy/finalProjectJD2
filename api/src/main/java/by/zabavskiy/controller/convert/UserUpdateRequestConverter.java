package by.zabavskiy.controller.convert;


import by.zabavskiy.controller.request.UserChangeRequest;
import by.zabavskiy.domain.User;
import by.zabavskiy.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class UserUpdateRequestConverter extends UserRequestConverter<UserChangeRequest, User> {

    @Override
    public User convert(UserChangeRequest request) {

        User user = ofNullable(entityManager.find(User.class, request.getId())).orElseThrow(EntityNotFoundException::new);
        return doConvert(user, request);
    }
}
