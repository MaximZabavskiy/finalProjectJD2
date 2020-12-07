package by.zabavskiy.daorepository.jdbc;

import by.zabavskiy.daorepository.UserDao;
import by.zabavskiy.domain.User;
import by.zabavskiy.domain.enums.FitnessLevel;
import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.domain.enums.GoalName;
import by.zabavskiy.domain.enums.Status;
import by.zabavskiy.exceptions.ResourceNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("userRepositoryJdbc")
public class UserDaoImpl implements UserDao {

    private static final Logger log = Logger.getLogger(UserDaoImpl.class);

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

    private DataSource dataSource;

    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> findAll() {
        final String findAllQuery = "select * from m_users order by id desc";

        List<User> resultList = new ArrayList<>();
        /*2. DriverManager should get connection*/
        try (
                Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
                PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery)) {

            log.debug("Getting connection");
            log.debug("Prepared statement creation");
            /*4. Execute query*/
            ResultSet resultSet = preparedStatement.executeQuery();
            log.debug("Executing query");
            while (resultSet.next()) {
                log.debug("Parsing result set");
                /*6. Add parsed info into collection*/
                resultList.add(parseResultSet(resultSet));
            }
            log.debug("Successfully parsed result set");
        } catch (SQLException e) {
            log.error("Find all method error!", e);
        }

        return resultList;
    }

    @Override
    public List<User> search(String searchParam) {
        final String findAllQueryForPrepared = "select * from m_users where id > ? order by id desc"; //:{the name of a parameter}    ?

        List<User> resultList = new ArrayList<>();
        /*2. DriverManager should get connection*/
        try (Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
             PreparedStatement preparedStatement = connection.prepareStatement(findAllQueryForPrepared)) {

            preparedStatement.setLong(1, Long.parseLong(searchParam));

            /*4. Execute query*/
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                /*6. Add parsed info into collection*/
                resultList.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultList;
    }

    @Override
    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(findOne(userId));
    }

    @Override
    public User findOne(Long userId) {
        final String findById = "select * from m_users where id = ?";

        User user = null;
        ResultSet resultSet = null;
        /*2. DriverManager should get connection*/
        try (Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
             PreparedStatement preparedStatement = connection.prepareStatement(findById);
        ) {

            preparedStatement.setLong(1, userId);
            /*4. Execute query*/
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                /*6. Add parsed info into collection*/
                user = parseResultSet(resultSet);
            } else {
                throw new ResourceNotFoundException("User with id " + userId + " not found");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                System.out.println(throwables.getMessage());
            }
        }

        return user;
    }

    @Override
    public User save(User user) {

        final String insertQuery = "INSERT INTO m_users (name, surname, username, password, email, gender, birth_date, height, weight, fitnessLevel, goal, created, changed, status, is_blocked)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
             PreparedStatement lastInsertId = connection.prepareStatement("SELECT currval('m_users_id_seq') as last_insert_id;");
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getGender().name());
            preparedStatement.setDate(7, user.getBirthDate());
            preparedStatement.setDouble(8, user.getHeight());
            preparedStatement.setDouble(9, user.getWeight());
            preparedStatement.setString(10, user.getFitnessLevel().name());
            preparedStatement.setString(11, user.getGoalName().name());
            preparedStatement.setTimestamp(12, user.getCreated());
            preparedStatement.setTimestamp(13, user.getChanged());
            preparedStatement.setString(14, user.getStatus().name());
            preparedStatement.setBoolean(15, user.isBlocked());

            preparedStatement.executeUpdate();

            ResultSet set = lastInsertId.executeQuery();
            set.next();
            long insertedUserId = set.getInt("last_insert_id");
            return findOne(insertedUserId);

        } catch (SQLException e) {
            throw new RuntimeException("Some issues in insert operation!", e);
        }
    }

    @Override
    public User update(User user) {
        final String updateQuery = "update m_users set (name = ?, surname = ?, username = ?, password = ?, email = ?, gender = ?, birth_date = ?, height = ?, weight = ?, fitnessLevel = ?, goal = ?, created = ?, changed = ?, status = ?, is_blocked = ? " +
                "where id = ?";

        try (Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getGender().name());
            preparedStatement.setDate(7, user.getBirthDate());
            preparedStatement.setDouble(8, user.getHeight());
            preparedStatement.setDouble(9, user.getWeight());
            preparedStatement.setString(10, user.getFitnessLevel().name());
            preparedStatement.setString(11, user.getGoalName().name());
            preparedStatement.setTimestamp(12, user.getCreated());
            preparedStatement.setTimestamp(13, user.getChanged());
            preparedStatement.setString(14, user.getStatus().name());
            preparedStatement.setBoolean(15, user.isBlocked());

            preparedStatement.setLong(16, user.getId());

            preparedStatement.executeUpdate();

            return findOne(user.getId());

        } catch (SQLException e) {
            throw new RuntimeException("Some issues in insert operation!", e);
        }
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    private User parseResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        /*5. Columns mapping*/
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
}
