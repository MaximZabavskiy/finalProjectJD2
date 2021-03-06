package by.zabavskiy.service.impl;

import by.zabavskiy.domain.User;
import by.zabavskiy.repository.UserRepository;
import by.zabavskiy.repository.impl.UserSpringDataRepository;
import by.zabavskiy.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserSpringDataRepository userSpringDataRepository;

    public UserServiceImpl(UserRepository userRepository, UserSpringDataRepository userSpringDataRepository) {
        this.userRepository = userRepository;
        this.userSpringDataRepository = userSpringDataRepository;
    }

    @Override
    public List<User> findAll() {
        return userSpringDataRepository.findAllUsers();
    }

    @Override
    public User save(User user) {
        return userSpringDataRepository.save(user);
    }

    @Override
    public User search(String gender, String firstName, String surname, String login, Long id, Date birthDate, Timestamp created, Timestamp changed) {
        return userSpringDataRepository.searchWithFunctionCall(gender, firstName, surname, login, id, birthDate, created, changed);
    }

    @Override
    public User update(User user) {
        return userSpringDataRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userSpringDataRepository.deleteById(id);
    }

    @Override
    public User findById(Long userId) {
        return userSpringDataRepository.findUserById(userId);
    }


    @Override
    public Optional<User> findByLogin(String login) {
        return userSpringDataRepository.findByLogin(login);
    }
//
//
//
//
//

//
//
//
//
//    @Override
//    public User findOne(Long userId) {
//        return userSpringDataRepository.getOne(userId);
//    }
//
//    @Override
//    public ResponseEntity<Object> testCreatingLinkRow(Long userId, Long goodId){
//        return new ResponseEntity<>(userSpringDataRepository.createSomeRow(userId, goodId), HttpStatus.CREATED);
//    }
//
//    @Override
//    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
//        return new ResponseEntity<Page<User>>(userSpringDataRepository.findAll(pageable), HttpStatus.OK);
//    }
//
//    @Override
//    public Optional<User> findUserById(Long id) {
//        return userSpringDataRepository.findById(id);
//    }


}
