package ru.kpfu.itis.sharipova.exceptions;

/**
 * Created by Baths on 13.10.2015.
 */
public class LongPasswordException extends Exception {
    public LongPasswordException() {
        super();
    }

    public LongPasswordException(String message) {
        super(message);
    }

    public LongPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public LongPasswordException(Throwable cause) {
        super(cause);
    }

    protected LongPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
