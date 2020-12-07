package by.zabavskiy.daorepository;

import by.zabavskiy.domain.hibernate.HibernateUser;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface HibernateUserDao {
    List<HibernateUser> findAll();

    List<Object> search(String searchParam);

    Optional<HibernateUser> findById(Long userId);

    HibernateUser findOne(Long userId);

    HibernateUser save(HibernateUser user) throws SQLException;

    HibernateUser update(HibernateUser user) throws SQLException;

    int delete(HibernateUser user);

    List<HibernateUser> criteriaFind();

    void testFirstLevelCache();
}
