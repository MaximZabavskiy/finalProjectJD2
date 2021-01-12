package by.zabavskiy.controller.convert;

import by.zabavskiy.controller.request.UserEditRequest;
import by.zabavskiy.domain.User;
import by.zabavskiy.exception.EntityNotFoundException;
import by.zabavskiy.repository.impl.UserSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserEditRequestConverter extends UserEntityConverter<UserEditRequest, User> {

    @Autowired
    private UserSpringDataRepository userRepository;

    public UserEditRequestConverter(PasswordEncoder passwordEncoder) {
        super(passwordEncoder);
    }

    @Override
    public User convert(UserEditRequest request) {

        User user = userRepository.findById(request.getId()).orElseThrow(EntityNotFoundException::new);
        return doConvert(user, request);

    }
}