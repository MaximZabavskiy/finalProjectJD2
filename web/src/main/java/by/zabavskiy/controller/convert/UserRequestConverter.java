package by.zabavskiy.controller.convert;

import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.enums.FitnessLevel;
import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.domain.enums.GoalName;
import by.zabavskiy.domain.enums.Status;
import by.zabavskiy.domain.hibernate.HibernateUser;
import by.zabavskiy.domain.hibernate.TimedEntity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.Date;

@Slf4j
public abstract class UserRequestConverter<S, T> extends EntityConverter<S, T> {

    protected HibernateUser doConvert(HibernateUser user, UserCreateRequest request) {


        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setBirthDate(request.getBirthDate());
        user.setHeight(request.getHeight());
        user.setWeight(request.getWeight());
        user.setFitnessLevel(request.getFitnessLevel());
        user.setGoalName(request.getGoalName());
        user.setStatus(request.getStatus());



        TimedEntity profileUpdates = user.getProfileUpdates();
        profileUpdates.setChanged(new Timestamp(new Date().getTime()));
        user.setProfileUpdates(profileUpdates);


        return user;
    }
}
