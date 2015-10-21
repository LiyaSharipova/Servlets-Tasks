package ru.kpfu.itis.sharipova.exceptions;

/**
 * Created by Baths on 13.10.2015.
 */
public class NotValidEmailException extends Exception {
    public NotValidEmailException() {
        super();
    }

    public NotValidEmailException(String message) {
        super(message);
    }

    public NotValidEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidEmailException(Throwable cause) {
        super(cause);
    }

    protected NotValidEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
