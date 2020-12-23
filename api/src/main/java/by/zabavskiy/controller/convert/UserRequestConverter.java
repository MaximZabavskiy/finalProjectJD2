package by.zabavskiy.controller.convert;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.CurrentStatus;
import by.zabavskiy.domain.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class UserRequestConverter<S, T> extends EntityConverter<S, T> {

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
        user.setGoalName(request.getGoalName());
        user.setCurrentStatus(new CurrentStatus(request.getIsBlocked()));




//        TimedEntity profileUpdates = user.getProfileUpdates();
//        profileUpdates.setChanged(new Timestamp(new Date().getTime()));
//        user.setProfileUpdates(profileUpdates);


        return user;
    }
}
