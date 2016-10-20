package by.epam.kinorating.service;

import by.epam.kinorating.dao.impl.GenreDAO;
import by.epam.kinorating.entity.Genre;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.exception.ServiceException;

import java.util.List;

/**
 * Created by Диана и Глеб on 01.09.2016.
 */
public class GenreService {
    public static List<Genre> findAll () throws ServiceException {
        try {
            return new GenreDAO().findAll();
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred during finding all genres", e);
        }
    }

    public static void addGenre (String g) throws ServiceException {
        Genre genre = new Genre();
        genre.setGenre(g);
        try {
            new GenreDAO().add(genre);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred in GenreService in addGenre() method", e);
        }
    }

    public static void delById (Long id) throws ServiceException {
        try {
            new GenreDAO().deleteById(id);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred in GenreService in delById() method", e);
        }
    }
}
