package by.zabavskiy.service;

import com.htp.domain.hibernate.HibernateUser;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface HibUserService {

    HibernateUser save(HibernateUser user) throws SQLException;

    List<HibernateUser> findAll();

    List<HibernateUser> criteriaSearch();

    List<Object> search(String query);

    Optional<HibernateUser> findById(Long userId);

    HibernateUser findOne(Long userId);
}
