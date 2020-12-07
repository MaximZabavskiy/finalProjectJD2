package by.zabavskiy.controller.convert;



import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.enums.SystemRoles;
import by.zabavskiy.domain.hibernate.HibernateRole;
import by.zabavskiy.domain.hibernate.HibernateUser;
import by.zabavskiy.domain.hibernate.TimedEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;

@Component
public class UserCreateRequestConverter extends UserRequestConverter<UserCreateRequest, HibernateUser> {

    @Override
    public HibernateUser convert(UserCreateRequest request) {

        HibernateUser user = new HibernateUser();

        TimedEntity timedEntity = new TimedEntity();
        timedEntity.setCreated(new Timestamp(new Date().getTime()));
        timedEntity.setChanged(new Timestamp(new Date().getTime()));
        user.setProfileUpdates(timedEntity);

        HibernateRole hibernateRole = new HibernateRole();
        hibernateRole.setRoleName(SystemRoles.ROLE_USER.name());
        hibernateRole.setUser(user);
        user.setRoles(Collections.singleton(hibernateRole));

        return doConvert(user, request);
    }
}
