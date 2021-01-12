package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserSpringDataRepository extends JpaRepository<User, Long> {

    //call function case
    @Query(value = "select * from smart_user_search(:gender, :firstName, :surname, :login, :id, :birthDate, :created, :changed)", nativeQuery = true)
    User searchWithFunctionCall(@Param("gender") String gender,
                @Param("firstName")String firstName,
                @Param("surname")String surname,
                @Param("login")String login,
                @Param("id")Long id,
                @Param("birthDate")Date birthDate,
                @Param("created")Timestamp created,
                @Param("changed")Timestamp changed);

    Optional<User> findByLogin(String login);

    @Query(value = "select u from User u order by u.id")
    List<User> findAllUsers();

    @Query(value = "select u from User u where u.id = :id ")
    User findUserById(@Param("id") Long id);
}
