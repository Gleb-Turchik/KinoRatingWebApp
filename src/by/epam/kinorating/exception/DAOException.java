package by.epam.kinorating.exception;


/**
 * Created by Диана и Глеб on 11.08.2016.
 */
public class DAOException extends Exception {
    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
