package by.epam.kinorating.dao.impl;

import by.epam.kinorating.dao.BaseDAO;
import by.epam.kinorating.entity.Country;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Диана и Глеб on 01.09.2016.
 */
public class CountryDAO implements BaseDAO<Country> {
    private static final String COUNTRY_ID = "country_id";
    private static final String COUNTRY_NAME = "country";

    private static final String SQL_FIND_ALL = "SELECT country_id, country FROM mydb.country";
    private static final String SQL_ADD_COUNTRY = "INSERT INTO mydb.country (country) VALUES (?)";
    private static final String SQL_UPDATE_COUNTRY = "UPDATE mydb.country SET country=? WHERE country_id=?";
    private static final String SQL_DELETE_COUNTRY = "DELETE FROM mydb.country WHERE country_id=?";

    @Override
    public List<Country> findAll() throws DAOException {
        List<Country> countries = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_ALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setCountryId(resultSet.getLong(COUNTRY_ID));
                country.setCountry(resultSet.getString(COUNTRY_NAME));
                countries.add(country);
            } return countries;
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during country getting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void add(Country country) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_ADD_COUNTRY);
            statement.setString(1, country.getCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during country adding", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public Country findById(Long id) throws DAOException {
        return null;
    }

    @Override
    public Country findByName(String name) throws DAOException {
        return null;
    }

    @Override
    public void deleteById(Long id) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_COUNTRY);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during country deleting", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }

    @Override
    public void updateById(Long id, Country country) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_COUNTRY);
            statement.setString(1, country.getCountry());
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Invalid database operation occurred during country updating", e);
        } finally {
            close(statement);
            pool.returnConnection(connection);
        }
    }
}
