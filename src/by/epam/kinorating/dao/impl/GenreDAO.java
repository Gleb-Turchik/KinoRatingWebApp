package by.epam.kinorating.dao.impl;

import by.epam.kinorating.dao.BaseDAO;
import by.epam.kinorating.entity.Genre;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Диана и Глеб on 01.09.2016.
 */
public class GenreDAO implements BaseDAO<Genre> {
    private static final String GENRE_ID = "genre_id";
    private static final String GENRE_NAME = "genre";

    private static final String SQL_FIND_ALL = "SELECT genre_id, genre FROM mydb.genre";
    private static final String SQL_ADD_GENRE = "INSERT INTO mydb.genre (genre) VALUES (?)";
    private static final String SQL_UPDATE_GENRE = "UPDATE mydb.genre SET genre=? WHERE genre_id=?";
    private static final String SQL_DELETE_GENRE = "DELETE FROM mydb.genre WHERE genre_id=?";

    @Override
    public List<Genre> findAll() throws DAOException {
        List<Genre> genres = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_ALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setGenreId(resultSet.getLong(GENRE_ID));
                genre.setGenre(resultSet.getString(GENRE_NAME));
                genres.add(genre);
            } return genres;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during genres getting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void add(Genre genre) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_ADD_GENRE);
            statement.setString(1, genre.getGenre());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during genre adding", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public Genre findById(Long id) throws DAOException {
        return null;
    }

    @Override
    public Genre findByName(String name) throws DAOException {
        return null;
    }

    @Override
    public void deleteById(Long id) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_GENRE);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during genre deleting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void updateById(Long id, Genre genre) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_GENRE);
            statement.setString(1, genre.getGenre());
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during genre updating", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }
}
