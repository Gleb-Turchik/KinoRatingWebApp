package by.epam.kinorating.service;

import by.epam.kinorating.dao.impl.UserDAO;
import by.epam.kinorating.entity.User;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.exception.ServiceException;

import java.util.List;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class UserService {

    public static boolean checkUser(String email, String password) throws ServiceException {
        try {
            User user = new UserDAO().getUser(email, password);
            return email.equals(user.getEmail()) && password.equals(user.getPassword());
        } catch (DAOException e) {
            throw new ServiceException("Invalid service operation occurred during checking user", e);
        }
    }

    public static User getUser (String email, String password) throws ServiceException {
        try {
            return new UserDAO().getUser(email, password);
        } catch (DAOException e) {
            throw new ServiceException("Invalid service operation occurred during getting user", e);
        }
    }

    public static boolean isAdmin (User user) {
        long roleID = user.getRole().getRoleId();
        return roleID == 1;
    }

    public static List<User> findAll () throws ServiceException {
        try {
            return new UserDAO().findAll();
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred in UserService in finAll() method", e);
        }
    }

    public static void banUser (long id) throws ServiceException {
        User user;
        UserDAO dao = new UserDAO();
        try {
            user = dao.findById(id);
            user.setBan(true);
            dao.updateById(id, user);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred in UserService in banUser() method", e);
        }
    }

    public static void unbanUser (long id) throws ServiceException {
        User user;
        UserDAO dao = new UserDAO();
        try {
            user = dao.findById(id);
            user.setBan(false);
            dao.updateById(id, user);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred in UserService in unbanUser() method", e);
        }
    }
}
