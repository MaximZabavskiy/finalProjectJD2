package by.zabavskiy.controller.convert;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.Date;

@RequiredArgsConstructor
public abstract class UserEntityConverter<S, T> implements Converter<S, T> {

    protected final PasswordEncoder passwordEncoder;

    protected User doConvert(User user, UserCreateRequest request) {

        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setBirthDate(request.getBirthDate());
        user.setHeight(request.getHeight());
        user.setWeight(request.getWeight());
        user.setFitnessLevel(request.getFitnessLevel());
        user.setGoal(request.getGoal());
        user.setMaxPullups(request.getMaxPullups());
        user.setMaxPushups(request.getMaxPushups());
        user.setMaxSquats(request.getMaxSquats());
        user.setMaxDips(request.getMaxDips());

        user.setChanged(new Timestamp(new Date().getTime()));

        return user;
    }
}
