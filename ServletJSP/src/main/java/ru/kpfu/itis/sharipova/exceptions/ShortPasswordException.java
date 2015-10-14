package ru.kpfu.itis.sharipova.exceptions;

/**
 * Created by Baths on 13.10.2015.
 */
public class ShortPasswordException extends Exception {
    public ShortPasswordException() {
        super();
    }

    public ShortPasswordException(String message) {
        super(message);
    }

    public ShortPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShortPasswordException(Throwable cause) {
        super(cause);
    }

    protected ShortPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
