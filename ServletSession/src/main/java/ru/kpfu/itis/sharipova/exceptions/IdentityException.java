package ru.kpfu.itis.sharipova.exceptions;

/**
 * Created by Baths on 15.10.2015.
 */
public class IdentityException extends Exception {
    public IdentityException() {
        super();
    }

    public IdentityException(String message) {
        super(message);
    }

    public IdentityException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdentityException(Throwable cause) {
        super(cause);
    }

    protected IdentityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
