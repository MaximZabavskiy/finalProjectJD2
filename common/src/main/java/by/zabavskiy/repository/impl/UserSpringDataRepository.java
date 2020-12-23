package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

public interface UserSpringDataRepository extends JpaRepository<User, Long> {

    /*call function case*/
    //@SuppressWarnings("")
    @Query(value = "select * from smart_user_search(:gender, :firstName, :surname, :login, :id, :birthDate, :created, :changed)", nativeQuery = true)
    User search(@Param("gender") String gender,
                @Param("firstName")String firstName,
                @Param("surname")String surname,
                @Param("login")String login,
                @Param("id")Long id,
                @Param("birthDate")Date birthDate,
                @Param("created")Timestamp created,
                @Param("changed")Timestamp changed);

    Optional<User> findByLogin(String login);




//    List<User> findByCredentials(CurrentStatus credentials);

//    List<User> findByLoginAndNameAndBirthDate(String login, String name, Date birthDate);
//
//    List<User> findByLoginAndNameOrBirthDateOrderByIdDescNameDesc(String login, String name, Date birthDate);
//
//    //select * from m_users where (login = ? and name = ?) or birth_date = ?
//
//    @Query(value = "select u from User u")
//    List<User> findByHQLQuery();
//
//    @Query(value = "select * from m_users", nativeQuery = true)
//    List<User> findByHQLQueryNative();
//
//    @Query(value = "select u from User u where u.credentials.login = :login and u.name = :userName")
//    List<User> findByHQLQuery(String login, @Param("userName") String name);
//
//
//
//    @Query("select u.id, u.name from User u")
//    List<Object[]> getPartsOfUser();
//
//    /*TODO: transaction manager configuration required*/
//    @Modifying
//    @Query(value = "insert into l_user_goods(user_id, good_id) values (:user_id, :good_id)", nativeQuery = true)
//    int createSomeRow(@Param("user_id") Long userId, @Param("good_id") Long goodId);
//
//
//    @Query(value = "select * from smart_user_search(:gender, :firstName, :surname, :login, :id, :birthDate, :created, :changed)", nativeQuery = true)
//    User findUserWithFunctionCall(@Param("gender") String gender,
//                                  @Param("firstName")String firstName,
//                                  @Param("surname")String surname,
//                                  @Param("login")String login,
//                                  @Param("id")Long id,
//                                  @Param("birthDate")Date birthDate,
//                                  @Param("created")Timestamp created,
//                                  @Param("changed")Timestamp changed);
//



}
