package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.User;
import by.zabavskiy.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@Log4j2
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    public UserRepositoryImpl(SessionFactory sessionFactory/*, EntityManager entityManager*/) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(user);
            transaction.commit();
            return user;
        }
    }


    @Override
    public User findById(Long key) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(User.class, key);
        }
    }


    @Override
    public Object testHql() {
        try (Session session = sessionFactory.openSession()) {

            String hqlQuery = "select u.id, u.name from User u where u.name like '%o%' ";

            return session.createQuery(hqlQuery).list();
        }
    }
}
