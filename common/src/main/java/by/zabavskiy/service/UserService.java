package by.zabavskiy.service;


import by.zabavskiy.domain.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User save(User user);

    User search(String gender, String firstName, String surname, String login, Long id, Date birthDate, Timestamp created, Timestamp changed);

    User update(User user);

    void deleteById(Long id);

    User findById(Long userId);

    Optional<User> findByLogin(String login);
}
