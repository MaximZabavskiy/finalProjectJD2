package by.zabavskiy.service;


import by.zabavskiy.domain.User;
import by.zabavskiy.domain.enums.Gender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User save(User user);

    User search(String gender, String firstName, String surname, String login, Long id, Date birthDate, Timestamp created, Timestamp changed);

    User update(User user);

    void deleteById(Long id);

    void delete(User user);

    User findById(Long userId);

    Optional<User> findByLogin(String login);


////    List<User> criteriaSearch();
//
//
//    User findOne(Long userId);
//
//
//
//
//    ResponseEntity<Object> testCreatingLinkRow(Long userId, Long goodId);
//
//    ResponseEntity<Page<User>> findAll(Pageable pageable);
//
//    Optional<User> findUserById(Long id);



}
