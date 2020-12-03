package by.zabavskiy.service;

import com.htp.dao.HibernateUserDao;
import com.htp.domain.hibernate.HibernateUser;
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

    //private HibernateUserService hibernateUserService;

    public HibernateUserService(HibernateUserDao hibernateUserRepository) {
        this.hibernateUserRepository = hibernateUserRepository;
    }

//    @Autowired
//    public void setHibernateUserService(HibernateUserService hibernateUserService) {
//        this.hibernateUserService = hibernateUserService;
//    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public HibernateUser save(HibernateUser user) throws SQLException {
        //hibernateUserService.findAll();

        return hibernateUserRepository.save(user);
    }

    //@Transactional
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
