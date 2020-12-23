package by.zabavskiy.repository;


import by.zabavskiy.domain.User;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<Long, User> {


//    List<User> criteriaSearch(SearchCriteria criteria);

//    Optional<User> findByLogin(String login);

//    Object testHql();

//    List<User> testCriteriaApi();

}
