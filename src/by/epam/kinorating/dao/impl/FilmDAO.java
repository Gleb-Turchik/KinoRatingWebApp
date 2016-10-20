package by.epam.kinorating.dao.impl;

import by.epam.kinorating.dao.BaseDAO;
import by.epam.kinorating.entity.Country;
import by.epam.kinorating.entity.Genre;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.entity.Film;
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
public class FilmDAO implements BaseDAO<Film> {
    private static final String FILM_ID = "film_id";
    private static final String FILM_COUNTRY_NAME = "country";
    private static final String FILM_GENRE_NAME = "genre";
    private static final String FILM_TITLE = "title";
    private static final String FILM_YEAR = "year";
    private static final String FILM_DURATION = "duration";
    private static final String FILM_DETAILS = "details";
    private static final String FILM_DIRECTOR = "director";
    private static final String FILM_ACTOR = "actor";
    private static final String FILM_TRAILER = "trailer";

    private static final String SQL_FIND_ALL =
            "SELECT film_id, title, year, duration, details, trailer, genre.genre, country.country, director, actor " +
                    "FROM mydb.film " +
                    "JOIN mydb.genre ON mydb.film.genre_id = mydb.genre.genre_id " +
                    "JOIN mydb.country ON mydb.film.country_id = mydb.country.country_id";

    private static final String SQL_FIND_FILM_BY_ID =
            "SELECT film_id, title, year, duration, details, trailer, genre.genre, country.country, director, actor " +
                    "FROM mydb.film " +
                    "JOIN mydb.genre ON mydb.film.genre_id = mydb.genre.genre_id " +
                    "JOIN mydb.country ON mydb.film.country_id = mydb.country.country_id " +
                    "WHERE film.film_id=?";

    private static final String SQL_FIND_FILM_BY_GENRE =
            "SELECT film_id, title, year, duration, details, trailer, genre.genre, country.country, director, actor " +
                    "FROM mydb.film " +
                    "JOIN mydb.genre ON mydb.film.genre_id = mydb.genre.genre_id " +
                    "JOIN mydb.country ON mydb.film.country_id = mydb.country.country_id " +
                    "WHERE film.genre_id=?";

    private static final String SQL_FIND_FILM_BY_TITLE =
            "SELECT film_id, title, year, duration, details, trailer, genre.genre, country.country, director, actor " +
                    "FROM mydb.film " +
                    "JOIN mydb.genre ON mydb.film.genre_id = mydb.genre.genre_id " +
                    "JOIN mydb.country ON mydb.film.country_id = mydb.country.country_id " +
                    "WHERE film.title=?";

    private static final String SQL_ADD_FILM =
            "INSERT INTO mydb.film " +
                    "(title, year, country_id, genre_id, duration, details, director, actor, trailer) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_FILM =
            "DELETE FROM mydb.film WHERE film_id=?";

    private static final String SQL_UPDATE_FILM =
            "UPDATE mydb.film " +
                    "SET title=?, year=?, duration=?, details=?, director=?, actor=?, country_id=?, genre_id=?, trailer=? " +
                    "WHERE film_id=?";

    private static final String SQL_COUNT_FILMS = "SELECT film_id FROM mydb.film";

    @Override
    public List<Film> findAll() throws DAOException {
        List<Film> films = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_ALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Film film = new Film();
                Country country = new Country();
                Genre genre = new Genre();
                film.setFilmId(resultSet.getLong(FILM_ID));
                film.setTitle(resultSet.getString(FILM_TITLE));
                film.setYear(resultSet.getInt(FILM_YEAR));
                film.setDuration(resultSet.getInt(FILM_DURATION));
                film.setDetails(resultSet.getString(FILM_DETAILS));
                film.setDirector(resultSet.getString(FILM_DIRECTOR));
                film.setActor(resultSet.getString(FILM_ACTOR));
                film.setTrailer(resultSet.getString(FILM_TRAILER));
                country.setCountry(resultSet.getString(FILM_COUNTRY_NAME));
                genre.setGenre(resultSet.getString(FILM_GENRE_NAME));
                film.setCountry(country);
                film.setGenre(genre);
                films.add(film);
            }
            return films;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred in findAllFilms method", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public Film findById(Long id) throws DAOException {
        Film film = new Film();
        Country country = new Country();
        Genre genre = new Genre();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_FILM_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                film.setFilmId(resultSet.getLong(FILM_ID));
                film.setTitle(resultSet.getString(FILM_TITLE));
                film.setYear(resultSet.getInt(FILM_YEAR));
                film.setDuration(resultSet.getInt(FILM_DURATION));
                film.setDetails(resultSet.getString(FILM_DETAILS));
                film.setDirector(resultSet.getString(FILM_DIRECTOR));
                film.setActor(resultSet.getString(FILM_ACTOR));
                film.setTrailer(resultSet.getString(FILM_TRAILER));
                country.setCountry(resultSet.getString(FILM_COUNTRY_NAME));
                genre.setGenre(resultSet.getString(FILM_GENRE_NAME));
                film.setCountry(country);
                film.setGenre(genre);
            }
            return film;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during film getting by ID", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void add(Film film) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_ADD_FILM);
            statement.setString(1, film.getTitle());
            statement.setInt(2, film.getYear());
            statement.setLong(3, film.getCountry().getCountryId());
            statement.setLong(4, film.getGenre().getGenreId());
            statement.setInt(5, film.getDuration());
            statement.setString(6, film.getDetails());
            statement.setString(7, film.getDirector());
            statement.setString(8, film.getActor());
            statement.setString(9, film.getTrailer());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during film adding", e);
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
            statement = connection.prepareStatement(SQL_DELETE_FILM);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during film deleting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public Film findByName(String title) throws DAOException {
        Film film = new Film();
        Country country = new Country();
        Genre genre = new Genre();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_FILM_BY_TITLE);
            statement.setString(1, title);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                film.setFilmId(resultSet.getLong(FILM_ID));
                film.setTitle(resultSet.getString(FILM_TITLE));
                film.setYear(resultSet.getInt(FILM_YEAR));
                film.setDuration(resultSet.getInt(FILM_DURATION));
                film.setDetails(resultSet.getString(FILM_DETAILS));
                film.setDirector(resultSet.getString(FILM_DIRECTOR));
                film.setActor(resultSet.getString(FILM_ACTOR));
                film.setTrailer(resultSet.getString(FILM_TRAILER));
                country.setCountry(resultSet.getString(FILM_COUNTRY_NAME));
                genre.setGenre(resultSet.getString(FILM_GENRE_NAME));
                film.setCountry(country);
                film.setGenre(genre);
            }
            return film;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during film getting by name", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void updateById(Long filmID, Film film) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_FILM);
            statement.setString(1, film.getTitle());
            statement.setInt(2, film.getYear());
            statement.setInt(3, film.getDuration());
            statement.setString(4, film.getDetails());
            statement.setString(5, film.getDirector());
            statement.setString(6, film.getActor());
            statement.setLong(7, film.getCountry().getCountryId());
            statement.setLong(8, film.getGenre().getGenreId());
            statement.setString(9, film.getTrailer());
            statement.setLong(10, filmID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during film updating", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    public List<Film> getByGenre(Long genreId) throws DAOException {
        List<Film> films = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_FILM_BY_GENRE);
            statement.setLong(1, genreId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Film film = new Film();
                Country country = new Country();
                Genre genre = new Genre();
                film.setFilmId(resultSet.getLong(FILM_ID));
                film.setTitle(resultSet.getString(FILM_TITLE));
                film.setYear(resultSet.getInt(FILM_YEAR));
                film.setDuration(resultSet.getInt(FILM_DURATION));
                film.setDetails(resultSet.getString(FILM_DETAILS));
                film.setDirector(resultSet.getString(FILM_DIRECTOR));
                film.setActor(resultSet.getString(FILM_ACTOR));
                film.setTrailer(resultSet.getString(FILM_TRAILER));
                country.setCountry(resultSet.getString(FILM_COUNTRY_NAME));
                genre.setGenre(resultSet.getString(FILM_GENRE_NAME));
                film.setCountry(country);
                film.setGenre(genre);
                films.add(film);
            }
            return films;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during film getting by genre", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    public int countFilms() throws DAOException {
        int count = 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_COUNT_FILMS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count++;
            }
            return count;
        } catch (SQLException | DAOException e) {
            throw new DAOException("Invalid database operation occurred during counting films", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }
}
