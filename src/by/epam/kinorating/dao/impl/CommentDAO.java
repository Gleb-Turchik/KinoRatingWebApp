package by.epam.kinorating.dao.impl;

import by.epam.kinorating.dao.BaseDAO;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.entity.Comment;
import by.epam.kinorating.pool.ConnectionPool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class CommentDAO implements BaseDAO<Comment> {
    private static final String COMMENT_ID = "comment_id";
    private static final String COMMENT_USER_ID = "user_id";
    private static final String COMMENT_USER_NAME = "name";
    private static final String COMMENT_FILM_ID = "film_id";
    private static final String COMMENT_TEXT = "text";
    private static final String COMMENT_DATE = "time";

    private static final String SQL_FIND_ALL = "SELECT comment_id, film_id, user_id, text, time, name " +
            "FROM mydb.comment NATURAL JOIN mydb.user";

    private static final String SQL_FIND_BY_ID = "SELECT comment_id, film_id, user_id, text, time, name " +
            "FROM mydb.comment NATURAL JOIN mydb.user WHERE comment_id=?";

    private static final String SQL_FIND_BY_FILM_ID = "SELECT comment_id, film_id, user_id, text, time, name " +
            "FROM mydb.comment NATURAL JOIN mydb.user WHERE film_id=?";

    private static final String SQL_ADD_COMMENT = "INSERT INTO mydb.comment (film_id, user_id, text, time) VALUES (?, ?, ?, ?)";

    private static final String SQL_DELETE_COMMENT = "DELETE FROM mydb.comment WHERE comment_id=?";

    private static final String SQL_UPDATE_COMMENT = "UPDATE mydb.comment SET text=? WHERE comment_id=?";

    @Override
    public List<Comment> findAll() throws DAOException {
        List<Comment> comments = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_ALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setCommentId(resultSet.getLong(COMMENT_ID));
                comment.setFilmId(resultSet.getLong(COMMENT_FILM_ID));
                comment.setUserId(resultSet.getLong(COMMENT_USER_ID));
                comment.setText(resultSet.getString(COMMENT_TEXT));
                comment.setDateTime(LocalDateTime.of(resultSet.getDate(COMMENT_DATE).toLocalDate(), resultSet.getTime(COMMENT_DATE).toLocalTime()));
                comment.setUserName(resultSet.getString(COMMENT_USER_NAME));
                comments.add(comment);
            } return comments;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during comments getting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public Comment findById(Long id) throws DAOException {
        Comment comment = new Comment();
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
                comment.setCommentId(resultSet.getLong(COMMENT_ID));
                comment.setFilmId(resultSet.getLong(COMMENT_FILM_ID));
                comment.setUserId(resultSet.getLong(COMMENT_USER_ID));
                comment.setText(resultSet.getString(COMMENT_TEXT));
                comment.setDateTime(LocalDateTime.of(resultSet.getDate(COMMENT_DATE).toLocalDate(), resultSet.getTime(COMMENT_DATE).toLocalTime()));
                comment.setUserName(resultSet.getString(COMMENT_USER_NAME));
            } return comment;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during comment getting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void add(Comment comment) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_ADD_COMMENT);
            statement.setLong(1, comment.getFilmId());
            statement.setLong(2, comment.getUserId());
            statement.setString(3, comment.getText());
            statement.setTimestamp(4, Timestamp.valueOf(comment.getDateTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during comment adding", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_COMMENT);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during comment deleting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public Comment findByName(String name) throws DAOException {
        return null;
    }

    @Override
    public void updateById(Long commentId, Comment comment) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_COMMENT);
            statement.setString(1, comment.getText());
            statement.setLong(2, commentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during comment updating", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    public List<Comment> findByFilmId(long id) throws DAOException {
        List<Comment> list = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_FILM_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setCommentId(resultSet.getLong(COMMENT_ID));
                comment.setFilmId(resultSet.getLong(COMMENT_FILM_ID));
                comment.setUserId(resultSet.getLong(COMMENT_USER_ID));
                comment.setText(resultSet.getString(COMMENT_TEXT));
                comment.setDateTime(LocalDateTime.of(resultSet.getDate(COMMENT_DATE).toLocalDate(), resultSet.getTime(COMMENT_DATE).toLocalTime()));
                comment.setUserName(resultSet.getString(COMMENT_USER_NAME));
                list.add(comment);
            } return list;
        } catch (SQLException e) {
            throw new DAOException("SQL error during getting comments by film id",e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }
}
