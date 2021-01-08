package by.zabavskiy.controller.convert;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.CurrentStatus;
import by.zabavskiy.domain.User;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.util.Date;

public abstract class EntityConverter<S, T> implements Converter<S, T> {

    protected User doConvert(User user, UserCreateRequest request) {

        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setBirthDate(request.getBirthDate());
        user.setHeight(request.getHeight());
        user.setWeight(request.getWeight());
        user.setFitnessLevel(request.getFitnessLevel());
        user.setGoal(request.getGoal());

        CurrentStatus currentStatus = new CurrentStatus();
        currentStatus.setBlocked(request.getIsBlocked());
        user.setCurrentStatus(currentStatus);

        user.setChanged(new Timestamp(new Date().getTime()));

        return user;
    }
}
