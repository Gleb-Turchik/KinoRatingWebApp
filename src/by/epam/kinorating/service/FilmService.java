package by.epam.kinorating.service;

import by.epam.kinorating.dao.impl.FilmDAO;
import by.epam.kinorating.entity.Film;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Диана и Глеб on 22.08.2016.
 */
public class FilmService {
    public static Film getById(long filmId) throws ServiceException {
        try {
            return new FilmDAO().findById(filmId);
        } catch (DAOException e) {
            throw new ServiceException("Invalid service operation occurred during getting film by ID", e);
        }
    }

    public static List<Film> getRandomFilms() throws ServiceException {
        FilmDAO dao = new FilmDAO();
        List<Film> films = new ArrayList<>();
        Random random = new Random();
        while (films.size() < 9 ) {
            Film film;
            try {
                long i = (random.nextInt(dao.countFilms()))+1;
                film = dao.findById(i);
                films.add(film);
            } catch (DAOException e) {
                throw new ServiceException("Invalid service operation occurred during getting random films", e);
            }
        }
        return films;
    }

    public static Film getRandomFilm() throws ServiceException {
        FilmDAO dao = new FilmDAO();
        try {
        long randomId = (new Random().nextInt(dao.countFilms()))+1;
        return dao.findById(randomId);
        } catch (DAOException e) {
            throw new ServiceException("Invalid service operation occurred during getting random film", e);
        }
    }

    public static List<Film> getByGenre (long genre) throws ServiceException {
        try {
            return new FilmDAO().getByGenre(genre);
        } catch (DAOException e) {
            throw new ServiceException("Invalid service operation occurred during getting film by genre", e);
        }
    }

    public static Film getByName (String title) throws ServiceException {
        try {
            return new FilmDAO().findByName(title);
        } catch (DAOException e) {
            throw new ServiceException("Invalid service operation occurred during getting film by name", e);
        }
    }

    public static List<Film> getAllFilms () throws ServiceException {
        try {
            return new FilmDAO().findAll();
        } catch (DAOException e) {
            throw new ServiceException("Invalid service operation occurred during getting all films", e);
        }
    }

    public static void editFilm (Film film) throws ServiceException {
        long filmID = film.getFilmId();
        try {
            new FilmDAO().updateById(filmID, film);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred during updating film", e);
        }
    }

    public static void addFilm (Film film) throws ServiceException {
        try {
            new FilmDAO().add(film);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occured during addfilm service operation", e);
        }
    }

    public static void delFilm (long filmId) throws ServiceException {
        try {
            new FilmDAO().deleteById(filmId);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred during deleting film", e);
        }
    }
}
