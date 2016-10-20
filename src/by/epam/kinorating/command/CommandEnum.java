package by.epam.kinorating.command;

import by.epam.kinorating.command.admin.*;
import by.epam.kinorating.command.film.*;
import by.epam.kinorating.command.comment.*;
import by.epam.kinorating.command.user.*;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public enum CommandEnum {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    LANGUAGE(new LanguageCommand()),
    GOREGPAGE(new GoToRegPageCommand()),
    REGISTRATION(new RegistrationCommand()),

    GETFILM(new SearchByIdCommand()),
    SEARCHBYGENRE(new SearchByGenreCommand()),
    SEARCHBYTITLE(new SearchByTitleCommand()),
    SEARCHRANDOM(new SearchRandomCommand()),
    FILLMAINPAGE(new FillMainPageCommand()),

    ADDCOMMENT(new AddCommentCommand()),

    EDITFILM(new EditFilmCommand()),
    DELFILM(new DelFilmCommand()),
    GOEDITPAGE(new GoToEditFilmCommand()),
    ADDFILM(new AddFilmCommand()),
    GOADDPAGE(new GoToAddFilmPageCommand()),
    GOEDITCOMMENT(new GoToEditCommentCommand()),
    EDITCOMMENT(new EditCommentCommand()),
    DELCOMMENT(new DelCommentCommand()),

    /*UPLOADPOSTER(new UploadPosterCommand()),*/
    GOHOME(new GoToMainPageCommand()),
    GOADMIN(new GoToAdminAccountCommand()),
    GOACCOUNT(new GoToAccountCommand()),
    GOEDITPROFILE(new GoToEditAccountCommand()),
    EDITPROFILE(new EditAccountCommand()),

    SEARCHALLFILMS(new SearchAllFilmCommand()),
    SEARCHALLCOMMENTS(new SearchAllCommentCommand()),
    SEARCHALLCOUNTRIES(new SearchAllCountrieCommand()),
    SEARCHALLGENRES(new SearchAllGenreCommand()),
    SEARCHALLUSERS(new SearchAllUserCommand()),
    ADDGENRE(new AddGenreCommand()),
    DELGENRE(new DelGenreCommand()),
    ADDCOUNTRY(new AddCountryCommand()),
    DELCOUNTRY(new DelCountryCommand()),
    BANUSER(new BanUserCommand()),
    UNBANUSER(new UnbanUserCommand()),
    RATE(new RatingCommand());

    private Command command;
    CommandEnum(Command command) {
        this.command = command;
    }
    public Command getCurrentCommand() {
        return command;
    }
}
