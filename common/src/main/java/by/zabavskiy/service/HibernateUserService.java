package by.zabavskiy.service;

import by.zabavskiy.daorepository.HibernateUserDao;
import by.zabavskiy.domain.hibernate.HibernateUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class HibernateUserService implements HibUserService {

    private HibernateUserDao hibernateUserRepository;

    public HibernateUserService(HibernateUserDao hibernateUserRepository) {
        this.hibernateUserRepository = hibernateUserRepository;
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public HibernateUser save(HibernateUser user) throws SQLException {

        return hibernateUserRepository.save(user);
    }

    public List<HibernateUser> findAll() {
        return hibernateUserRepository.findAll();
    }

    @Override
    public List<Object> search(String query) {
        return hibernateUserRepository.search(query);
    }

    @Override
    public List<HibernateUser> criteriaSearch() {
        return hibernateUserRepository.criteriaFind();
    }

    public Optional<HibernateUser> findById(Long userId) {
        return hibernateUserRepository.findById(userId);
    }

    public HibernateUser findOne(Long userId) {
        return hibernateUserRepository.findOne(userId);
    }
}
