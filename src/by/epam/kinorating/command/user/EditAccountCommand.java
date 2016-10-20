package by.epam.kinorating.command.user;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Parameter;
import by.epam.kinorating.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 05.09.2016.
 */
public class EditAccountCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(Parameter.PARAMETER_USER_NAME);
        String surname = request.getParameter(Parameter.PARAMETER_USER_SURNAME);
        String email = request.getParameter(Parameter.PARAMETER_USER_EMAIL);
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
          //TODO  проверить корректность полей  и если ок обновить аккаунт
        return null;
    }
}
