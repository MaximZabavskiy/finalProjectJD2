package by.zabavskiy.daorepository.hibernate;

import com.htp.dao.HibernateUserDao;
import com.htp.domain.Gender;
import com.htp.domain.hibernate.HibernateUser;
import com.htp.domain.hibernate.HibernateUser_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository("userHibernateRepository")
public class UserHibernateRepository implements HibernateUserDao {

    private SessionFactory sessionFactory;

    private EntityManagerFactory entityManagerFactory;

    public UserHibernateRepository(SessionFactory sessionFactory, EntityManagerFactory entityManagerFactory) {
        this.sessionFactory = sessionFactory;
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<HibernateUser> findAll() {
//        try (Session session = sessionFactory.openSession()) {
//            return session.createQuery("select user from HibernateUser user order by user.id asc", HibernateUser.class).list();
//        }

        /*2. JPQL Query - analog native query (Select * from m_users order by id asc)*/
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        return entityManager.createQuery("select user from HibernateUser user order by user.id asc", HibernateUser.class).getResultList();

        /*3. Native query example*/
//        try (Session session = sessionFactory.openSession()) {
//            return session.createNativeQuery("select * from m_users order by id", HibernateUser.class).list();
//        }

        /*4. HQL query with where statement*/
//        final String query = "select user from HibernateUser user " +
//                " inner join user.roles as role " +
//                " where role.roleName = 'ROLE_ADMIN' " +
//                " and user.gender = :gender " +
//                " and user.login like '%a%' " +
//                " and user.weight between 10 and 100 " +
//                " and user.gender not in ('MALE', 'FEMALE') " +
//                " order by user.id asc";

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        return entityManager.createQuery(query, HibernateUser.class).getResultList();

        try (Session session = sessionFactory.openSession()) {
            Query<HibernateUser> findAllQuery = session.createNamedQuery("HibernateUser_findAll", HibernateUser.class);

            //findAllQuery.setParameter("gender", Gender.NOT_SELECTED.name());

            return findAllQuery.list();
        }
    }

    /*TODO: Spring Data Query to try*/
    /*List<List<Object>>*/
    @Override
    public List<Object> search(String searchParam) {
        final String query = "select user.id as id, user.login as login, role.roleName as roleName from HibernateUser user " +
                " inner join user.roles as role " +
                " where role.roleName = 'ROLE_ADMIN' " +
                " and user.gender = :gender " +
                " and user.login like '%a%' " +
                " and user.weight between 10 and 100 " +
                " and user.gender not in ('MALE', 'FEMALE') " +
                " order by user.id asc";

        try (Session session = sessionFactory.openSession()) {
            Query findAllQuery = session.createQuery(query);
            findAllQuery.setParameter("gender", Gender.NOT_SELECTED.name());

            return findAllQuery.list();
        }
    }

    @Override
    public List<HibernateUser> criteriaFind() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder(); //create query and query parts
        CriteriaQuery<HibernateUser> query = cb.createQuery(HibernateUser.class); //select user
        Root<HibernateUser> root = query.from(HibernateUser.class); //from HibernateUser user

        Expression<Long> id = root.get(HibernateUser_.id);
        Expression<Gender> gender = root.get(HibernateUser_.gender);
        Expression<String> surname = root.get(HibernateUser_.surname);

        ParameterExpression<Gender> genderParameter = cb.parameter(Gender.class);
        /*TODO: check explicit string param*/
        ParameterExpression<String> surnameParameter = cb.parameter(String.class);

        query.select(root)
                .distinct(true)
                .where(
                        cb.and(
                                cb.like(root.get(HibernateUser_.surname), "%Kalevich%"),
                                //id.in(1, 2, 3, 4, 5, 6)
                                cb.gt(id, 5L)
                        )
                )
                .where(
                        cb.equal(root.get(HibernateUser_.gender), genderParameter)
                )
                .orderBy(cb.asc(root.get(HibernateUser_.surname)));


        TypedQuery<HibernateUser> findAllQuery = entityManager.createQuery(query);
        findAllQuery.setParameter(genderParameter, Gender.NOT_SELECTED);

        return findAllQuery.getResultList();
    }

    @Override
    public Optional<HibernateUser> findById(Long userId) {
        return Optional.of(findOne(userId));
    }

    @Override
    public HibernateUser findOne(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(HibernateUser.class, userId);
        }
    }

    @Override
    public HibernateUser save(HibernateUser user) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(user);
            throw new SQLException("PErform Rollback !");
            //return user;
        }
    }

    private void saveWrapper(Session session, HibernateUser user) {
        session.saveOrUpdate(user);
        throw new RuntimeException("PErform Rollback !");
    }

    @Override
    public HibernateUser update(HibernateUser user) throws SQLException {
        return save(user);
    }

    @Override
    public int delete(HibernateUser user) {
        return 0;
    }

    @Override
    public void testFirstLevelCache() {
        try (
                Session session = sessionFactory.openSession();
                Session session1 = sessionFactory.openSession();
        ) {

            Transaction transaction = session.beginTransaction();
            List<HibernateUser> allUsers =
                    session
                            .createQuery("select user from HibernateUser user where user.id = 1", HibernateUser.class)
                            .setCacheable(true)
                            .list();

            transaction.commit();
            session.close();

            Transaction transaction1 = session1.beginTransaction();
            List<HibernateUser> allUsers1 =
                    session1
                            .createQuery("select user from HibernateUser user where user.id = 1", HibernateUser.class)
                            .setCacheable(true)
                            .list();

            transaction1.commit();
            session1.close();


            /*First session*/
//            Transaction transaction = session.beginTransaction();
//            HibernateUser hibernateUser = session.get(HibernateUser.class, 1L);
//            HibernateUser hibernateUser1 = session.get(HibernateUser.class, 1L);
//            transaction.commit();
//            session.close();
//
//            /*Second session*/
//            Transaction transaction1 = session1.beginTransaction();
//            HibernateUser hibernateUser2 = session1.get(HibernateUser.class, 1L);
//            HibernateUser hibernateUser3 = session1.get(HibernateUser.class, 1L);
//            transaction1.commit();
//            session1.close();

            //entityManagerFactory.createEntityManager().find()
        }
    }
}
