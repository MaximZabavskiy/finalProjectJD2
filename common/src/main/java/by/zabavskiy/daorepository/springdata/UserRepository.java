package by.zabavskiy.daorepository.springdata;

import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.domain.hibernate.HibernateUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

@CacheConfig(cacheNames = {"usersAdmins"})
public interface UserRepository extends CrudRepository<HibernateUser, Long>, JpaRepository<HibernateUser, Long>, PagingAndSortingRepository<HibernateUser, Long> {


    /*select * from n_users where is_blocked is not true*/
    List<HibernateUser> findByBlockedIsTrueAndGenderIsAndUsernameEquals(Gender gender, String username);

    @Cacheable
    @Query(value = "select u from HibernateUser u join u.roles role where role.roleName = 'ROLE_ADMIN' ")
    List<HibernateUser> findUsersWithAdminRoles();

    @Query(value = "select u from HibernateUser u join u.roles role where role.roleName = :role ")
    List<HibernateUser> findUsersWithAdminRolesWithParams(@Param("role") String searchRole);

    @Query(value = "select * from m_users inner join m_roles mr on m_users.id = mr.user_id where role_name = :role", nativeQuery = true)
    List<HibernateUser> findUsersWithAdminRolesWithParamsNative(@Param("role") String searchRole);

    @Query("select u.username from HibernateUser u order by u.id")
    List<String> findAllUserNames();

    @Query("select u.birthDate from HibernateUser u order by u.id")
    List<Date> findAllBirthDate();

    @Query("select u.id, u.name, u.username, u.surname from HibernateUser u order by u.id")
    List<Object[]> findAllUserProfiles();

    //Not recommended
//    @Query("select u.id, u.login, u.username, u.surname from HibernateUser u order by u.id")
//    List<UserProfile> findAllUserProfilesCoolVersion();

    @Modifying
    @Query("update HibernateUser u set u.surname = :username")
    int updateUserSurname(String username);
}