package by.zabavskiy.daorepository;


import by.zabavskiy.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    /*CRUD operations*/
    /*Create = Insert*/
    /*Read = select*/
    /*Update*/
    /*Delete*/
    List<User> findAll();

    List<User> search(String searchParam);

    Optional<User> findById(Long userId);

    User findOne(Long userId);

    User save(User user);

    User update(User user);

    int delete(User user);
    
    //use batch for saving collection of users

}
