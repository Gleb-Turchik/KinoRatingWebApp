package by.epam.kinorating.exception;


/**
 * Created by Диана и Глеб on 11.08.2016.
 */
public class ServiceException extends Exception {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
