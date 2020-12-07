package by.zabavskiy.daorepository.jdbctemplate;


import by.zabavskiy.daorepository.UserDao;
import by.zabavskiy.domain.User;
import by.zabavskiy.domain.enums.FitnessLevel;
import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.domain.enums.GoalName;
import by.zabavskiy.domain.enums.Status;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository("userRepositoryJdbcTemplate")

public class UserRepository implements UserDao {

    public static final String USER_ID = "id";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";
    public static final String USER_GENDER = "gender";
    public static final String USER_BIRTH_DATE = "birth_date";
    public static final String USER_HEIGHT = "height";
    public static final String USER_WEIGHT = "weight";
    public static final String USER_FITNESS_LEVEL = "fitnessLevel";
    public static final String USER_GOAL = "goal";
    public static final String USER_CREATED = "created";
    public static final String USER_CHANGED = "changed";
    public static final String USER_STATUS = "status";
    public static final String USER_IS_BLOCKED = "is_blocked";


    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        /*Here will be aspect logic Before*/

        final String findAllQuery = "select * from m_users order by id desc";
        /*Here will be aspect logic After*/
        return jdbcTemplate.query(findAllQuery, this::userRowMapper);
        /*Here will be aspect logic AfterReturning*/
        /*Here will be aspect logic AfterThrowing*/
    }

    private User userRowMapper(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(USER_ID));
        user.setName(resultSet.getString(USER_NAME));
        user.setSurname(resultSet.getString(USER_SURNAME));
        user.setUsername(resultSet.getString(USER_USERNAME));
        user.setPassword(resultSet.getString(USER_PASSWORD));
        user.setEmail(resultSet.getString(USER_EMAIL));
        user.setGender(Gender.valueOf(resultSet.getString(USER_GENDER)));
        user.setBirthDate(resultSet.getDate(USER_BIRTH_DATE));
        user.setHeight(resultSet.getFloat(USER_HEIGHT));
        user.setWeight(resultSet.getFloat(USER_WEIGHT));
        user.setFitnessLevel(FitnessLevel.valueOf(resultSet.getString(USER_FITNESS_LEVEL)));
        user.setGoalName(GoalName.valueOf(resultSet.getString(USER_GOAL)));
        user.setCreated(resultSet.getTimestamp(USER_CREATED));
        user.setChanged(resultSet.getTimestamp(USER_CHANGED));
        user.setStatus(Status.valueOf(resultSet.getString(USER_STATUS)));
        user.setBlocked(resultSet.getBoolean(USER_IS_BLOCKED));
        return user;
    }

    @Override
    public List<User> search(String searchParam) {
        final String searchQuery = "select * from m_users where login = ? order by id desc";
        /*Here will be aspect logic After*/
        return jdbcTemplate.query(searchQuery, this::userRowMapper, searchParam);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return Optional.empty();
    }

    @Override
    public User findOne(Long userId) {
        final String findById = "select * from m_users where id = ?";

        /*Here will be aspect logic After*/
        return jdbcTemplate.queryForObject(findById, this::userRowMapper, userId);
    }

    @Override
    public User save(User user) {
        final String insert = "INSERT INTO m_users (name, surname, username, password, email, gender, birth_date, height, weight, fitnessLevel, goal, created, changed, status, is_blocked)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        final String getLastId = "SELECT currval('m_users_id_seq') as last_insert_id;";

        jdbcTemplate.update(insert,
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getGender().name(),
                user.getBirthDate(),
                user.getHeight(),
                user.getWeight(),
                user.getFitnessLevel().name(),
                user.getGoalName().name(),
                user.getCreated(),
                user.getChanged(),
                user.getStatus().name(),
                user.isBlocked()
        );

        Long lastUserId = jdbcTemplate.queryForObject(getLastId, Long.class);

        return findOne(lastUserId);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public int delete(User user) {
        return 0;
    }
}
