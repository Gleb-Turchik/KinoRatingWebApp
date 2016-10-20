package by.epam.kinorating.dao.impl;

import by.epam.kinorating.dao.BaseDAO;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.entity.Role;
import by.epam.kinorating.entity.User;
import by.epam.kinorating.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class UserDAO implements BaseDAO<User> {
    private static final String USER_ID = "user_id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String BAN = "ban";
    private static final String ROLE_ID = "role_id";
    private static final String ROLE = "role";


    private static final String SQL_SELECT_ALL = "SELECT * FROM mydb.user NATURAL JOIN mydb.role";

    private static final String SQL_SELECT_USER = "SELECT * FROM mydb.user  NATURAL JOIN mydb.role WHERE email=? AND password=?";

    private static final String SQL_ADD_USER = "INSERT INTO mydb.user (name, surname, email, password, role_id, ban) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_USER = "DELETE FROM mydb.user WHERE user_id=?";

    private static final String SQL_CHECK_LOGIN = "SELECT user.user_id FROM mydb.user WHERE email=?";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM mydb.user NATURAL JOIN mydb.role WHERE user_id=?";

    private static final String SQL_UPDATE_FILM = "UPDATE mydb.user SET name=?, surname=?, email=?, ban=?, role_id=? WHERE user_id=?";

    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(USER_ID));
                user.setName(resultSet.getString(NAME));
                user.setSurname(resultSet.getString(SURNAME));
                user.setEmail(resultSet.getString(EMAIL));
                user.setBan(resultSet.getBoolean(BAN));

                Role role = new Role();
                role.setRole(resultSet.getString(ROLE));
                role.setRoleId(resultSet.getLong(ROLE_ID));
                user.setRole(role);

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DAOException ("Invalid database operation occurred during user getting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void add(User user) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_ADD_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setLong(5, user.getRole().getRoleId());
            statement.setBoolean(6, user.isBaned());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during user adding", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public User findById(Long id) throws DAOException {
        User user = new User();
        Role role = new Role();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getLong(USER_ID));
                user.setName(resultSet.getString(NAME));
                user.setSurname(resultSet.getString(SURNAME));
                user.setEmail(resultSet.getString(EMAIL));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setBan(resultSet.getBoolean(BAN));
                role.setRole(resultSet.getString(ROLE));
                role.setRoleId(resultSet.getLong(ROLE_ID));
                user.setRole(role);
            }
            return user;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during user", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }

    }

    @Override
    public User findByName(String name) throws DAOException { //  TODO   EMPTY method
        return null;
    }

    @Override
    public void deleteById(Long id) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_USER);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during user deleting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void updateById(Long id, User user) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_FILM);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setBoolean(4, user.isBaned());
            statement.setLong(5, user.getRole().getRoleId());
            statement.setLong(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during user updating", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }

    }

    public User getUser(String email, String password) throws DAOException {
        User user = new User();
        Role role = new Role();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_USER);
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getLong(USER_ID));
                user.setName(resultSet.getString(NAME));
                user.setSurname(resultSet.getString(SURNAME));
                user.setEmail(resultSet.getString(EMAIL));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setBan(resultSet.getBoolean(BAN));
                role.setRole(resultSet.getString(ROLE));
                role.setRoleId(resultSet.getLong(ROLE_ID));
                user.setRole(role);
            }
            return user;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during user", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    public boolean isAlreadyExist(String email) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_CHECK_LOGIN);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during isAlreadyExist method");
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }
}
