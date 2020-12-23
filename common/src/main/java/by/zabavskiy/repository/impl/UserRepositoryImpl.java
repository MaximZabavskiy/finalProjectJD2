package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.User;
import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Log4j2
public class UserRepositoryImpl implements UserRepository {

//    private UserSpringDataRepository userSpringDataRepository;

    private SessionFactory sessionFactory;

//    private EntityManager entityManager;

    public UserRepositoryImpl(SessionFactory sessionFactory/*, EntityManager entityManager*/) {
        this.sessionFactory = sessionFactory;
//        this.entityManager = entityManager;
    }

    @Override
    public User update(User object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(object);
            transaction.commit();
            return object;
        }
    }

    @Override
    public User findById(Long key) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(User.class, key);
        }
    }









//    @Override
//    public List<User> criteriaSearch(@ModelAttribute SearchCriteria criteria) { // using criteriaAPI
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class); //here select, where, orderBy, having
//        Root<User> root = criteriaQuery.from(User.class); //here params  select * from m_users -> mapping
//
//        ParameterExpression<String> param = cb.parameter(String.class);
//
//        Expression<String> name = root.get(User_.name);
//
//        criteriaQuery.select(root)
//                .distinct(true)
//                .where(
//                        cb.like(name, param)
//                )
//                .orderBy(cb.asc(root.get(User_.id)));
//
//        TypedQuery<User> resultQuery = entityManager.createQuery(criteriaQuery); //prepared statement on hql
//        resultQuery.setParameter(param, StringUtils.join("%", criteria.getQuery(), "%"));
//        resultQuery.setParameter(userSearchParam, criteria.getUserLowerId());
//        return resultQuery.getResultList();


//    }

//    @Override
//    public User search(String gender, String firstName, String surname, String login, Long id, Date birthDate, Timestamp created, Timestamp changed) {
//        return new User(userSpringDataRepository.findUserWithFunctionCall(gender, firstName, surname, login, id, birthDate, created, changed);
//    }

//    @Override
//    public Optional<User> findByLogin(String login) {
//        Session session = sessionFactory.openSession();
//        //TODO: fix cache provider
//        session.beginTransaction();
//
//        List<User> resultList = session.createQuery("select u from User u where u.id = 1L", User.class)
//                .setCacheable(true)
//                .getResultList();
//
//        session.get(User.class, 1L);
//        session.getTransaction().commit();
//        session.close();
//
//
//        Session session1 = sessionFactory.openSession();
//        Transaction transaction1 = session1.beginTransaction();
//        resultList = session1.createQuery("select u from User u where u.id = 1L", User.class)
//                .setCacheable(true)
//                .getResultList();
//
//        transaction1.commit();
//        session1.close();
//
//        return Optional.of(new User());
//    }
//
//    @Override
//    public Object testHql() {
//        try (Session session = sessionFactory.openSession()) {
//
//
//            /*1. Change table name to mapped Entity: m_users -> User u*/
//            /*2. Change table column names to mapped Entity fields:
//                  select * from m_users
//                  select u from User u
//
//                  select id, name, birth_date from m_users
//                  select u.id, u.name, u.birthDate from User u
//                  */
//
//            String hqlQuery =
//                    //"from User";
//                    //"select u from User u";
//                    "select u.id, role.roleName, u.weight from User u left join u.role as role " +
////                            " " +
//                            "where role.roleName = com.noirix.domain.SystemRoles.ROLE_ADMIN " +
//                            "and u.weight > (select avg(u.weight) from User u) " +
//                            "and u.id in(45, 46, 42) " +
//                            "and u.name like '%o%' " +
////                            "having u.weight > avg(u.weight) " +
//                            "";
//            //"";
//            //"";
//            //"";
//
//            return session.createQuery(hqlQuery).list();
////
////            return Collections.singletonList(session.find(User.class, 6L));
//        }
//        return null;
//    }
//
//    @Override
//    public List<User> testCriteriaApi() {
//
//        return null;
//        /*//1. Get Builder for Criteria object
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<User> query = cb.createQuery(User.class); //here select, where, orderBy, having
//        Root<User> root = query.from(User.class); //here params  select * from m_users -> mapping
//
//        *//*type of future params in prepared statement*//*
//        ParameterExpression<String> param = cb.parameter(String.class);
//        ParameterExpression<Long> userSearchParam = cb.parameter(Long.class);
//
//        *//*Provide access to fields in class that mapped to columns*//*
//        Expression<Long> id = root.get(HibernateUser_.id);
//        Expression<String> name = root.get(HibernateUser_.name);
//        Expression<String> surname = root.get(HibernateUser_.surname);
//        //Expression<String> password = root.get(HibernateUser_.credentials).get(Credentials_.password);
//
//        *//*SQL Query customizing*//*
//        query.select(root)
//                .distinct(true)
//                .where(
//                        cb.or(
//                                cb.like(name, param),  //userName like param
//                                cb.like(surname, param)  //userSurname like param
//                        ),
//                        cb.and(
//                                cb.gt(root.get(HibernateUser_.id), userSearchParam), //>0
//                                cb.not(id.in(40L, 50L)) //in (40,50)
//                        )
//                        ,
//                        cb.between(
//                                root.get(TestUser_.birthDate),
//                                new Timestamp(new Date().getTime()),
//                                new Timestamp(new Date().getTime())
//                        )
//                )
//                .orderBy(cb.asc(root.get(HibernateUser_.id)));
//
//        TypedQuery<User> resultQuery = entityManager.createQuery(query); //prepared statement on hql
//        resultQuery.setParameter(param, StringUtils.join("%", criteria.getQuery(), "%"));
//        resultQuery.setParameter(userSearchParam, criteria.getUserLowerId());
//        return resultQuery.getResultList();*/
//
//    }




}
