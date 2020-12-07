package by.zabavskiy.controller.convert;


import by.zabavskiy.controller.request.UserUpdateRequest;
import by.zabavskiy.domain.hibernate.HibernateUser;
import by.zabavskiy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class UserUpdateRequestConverter extends UserRequestConverter<UserUpdateRequest, HibernateUser> {

    @Override
    public HibernateUser convert(UserUpdateRequest request) {

        HibernateUser hibernateUser = ofNullable(entityManager.find(HibernateUser.class, request.getUserId())).orElseThrow(ResourceNotFoundException::new);
        return doConvert(hibernateUser, request);
    }
}
