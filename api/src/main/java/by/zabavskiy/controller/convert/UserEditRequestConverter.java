package by.zabavskiy.controller.convert;

import by.zabavskiy.controller.request.UserChangeRequest;
import by.zabavskiy.domain.User;
import by.zabavskiy.exception.EntityNotFoundException;
import by.zabavskiy.repository.impl.UserSpringDataRepository;
import org.springframework.stereotype.Component;

@Component
public class UserEditRequestConverter extends EntityConverter<UserChangeRequest, User> {

    private UserSpringDataRepository userRepository;

    public UserEditRequestConverter(UserSpringDataRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User convert(UserChangeRequest request) {

        User user = userRepository.findById(request.getId()).orElseThrow(EntityNotFoundException::new);
        return doConvert(user, request);
    }
}