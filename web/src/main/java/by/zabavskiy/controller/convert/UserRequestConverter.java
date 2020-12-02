package by.zabavskiy.controller.convert;

import com.htp.controller.request.UserCreateRequest;
import com.htp.domain.hibernate.HibernateUser;
import com.htp.domain.hibernate.TimedEntity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.Date;

@Slf4j
public abstract class UserRequestConverter<S, T> extends EntityConverter<S, T> {

    protected HibernateUser doConvert(HibernateUser user, UserCreateRequest request) {

        user.setUsername(request.getUsername());
        user.setSurname(request.getSurname());
        user.setBirthDate(request.getBirthDate());
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());

        TimedEntity profileUpdates = user.getProfileUpdates();
        profileUpdates.setChanged(new Timestamp(new Date().getTime()));
        user.setProfileUpdates(profileUpdates);

        user.setWeight(request.getWeight());

        return user;
    }
}
