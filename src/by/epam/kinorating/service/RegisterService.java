package by.epam.kinorating.service;

import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.Pattern;
import by.epam.kinorating.dao.impl.UserDAO;
import by.epam.kinorating.entity.User;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.manager.MessageManager;

/**
 * Created by Диана и Глеб on 28.08.2016.
 */
public class RegisterService {
    public static String addUser (User user, String locale) throws ServiceException {
        UserDAO dao = new UserDAO();
        String message;
        try {
            if (dao.isAlreadyExist(user.getEmail())) {
                message = MessageManager.getMessage(Message.MESSAGE_USER_EXIST, locale);
            } else {
                dao.add(user);
                message = MessageManager.getMessage(Message.MESSAGE_SUCCESS, locale);
            }
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred during adding new user", e);
        }
        return message;
    }

    public static String checkFields (User user, String locale) {
        String msg;
        if ((msg = validate(user, locale)) != null) {
            return msg;
        } return null;
    }

    private static String validate(User user, String locale) {

        //проверка имени
        if (!java.util.regex.Pattern.compile(Pattern.PATTERN_NAME).matcher(user.getName()).matches()) {
            //если совпадение не найдено
            return MessageManager.getMessage(Message.MESSAGE_INVALID_NAME, locale);
        }

        //проверка фамилии
        if (!java.util.regex.Pattern.compile(Pattern.PATTERN_SURNAME).matcher(user.getSurname()).matches()) {
            //если совпадение не найдено
            return MessageManager.getMessage(Message.MESSAGE_INVALID_SURNAME, locale);
        }

        //проверка пароля
        if (!java.util.regex.Pattern.compile(Pattern.PATTERN_PASSWORD).matcher(user.getPassword()).matches()) {
            //если совпадение не найдено
            return MessageManager.getMessage(Message.MESSAGE_INVALID_PASSWORD, locale);
        }

        //проверка email
        if(!java.util.regex.Pattern.compile(Pattern.PATTERN_EMAIL).matcher(user.getEmail()).matches()) {
            //если совпадение не найдено
            return MessageManager.getMessage(Message.MESSAGE_INVALID_EMAIL, locale);
        }
        return null;
    }

}
