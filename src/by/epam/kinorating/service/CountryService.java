package by.epam.kinorating.service;

import by.epam.kinorating.dao.impl.CountryDAO;
import by.epam.kinorating.entity.Country;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.exception.ServiceException;

import java.util.List;

/**
 * Created by Диана и Глеб on 01.09.2016.
 */
public class CountryService {

    public static List<Country> findAllCountries () throws ServiceException {
        try {
            return new CountryDAO().findAll();
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred in service during finding all countries", e);
        }
    }

    public static void addCountry (String value) throws ServiceException {
        Country country = new Country();
        country.setCountry(value);
        try {
            new CountryDAO().add(country);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred in CountryService in addCountry() method", e);
        }
    }

    public static void delCountry (Long id) throws ServiceException {
        try {
            new CountryDAO().deleteById(id);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred in CountryService in delCountry() method", e);
        }
    }
}
