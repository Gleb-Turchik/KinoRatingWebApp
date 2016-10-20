package by.epam.kinorating.dao;

import by.epam.kinorating.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Gleb Turchik on 11.08.2016.
 * The {@code InterfaceDao} interface enumerates all the necessary methods
 * for manipulation with data in database.
 */
public interface BaseDAO<T> {
    Logger LOG = LogManager.getLogger();
    List<T> findAll() throws DAOException;
    void add(T t) throws DAOException;
    T findById(Long id) throws DAOException;
    T findByName(String name) throws DAOException;
    void deleteById(Long id) throws DAOException;
    void updateById(Long id, T t) throws DAOException;
    /**
     * Default method for closing Statement connection.
     *
     * @param statement is an instance of {@code Statement}
     *                  class.
     */
    default void close(Statement statement) {

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            LOG.error("Exception occurred during closing statement" + e.getMessage());
        }
    }

}
