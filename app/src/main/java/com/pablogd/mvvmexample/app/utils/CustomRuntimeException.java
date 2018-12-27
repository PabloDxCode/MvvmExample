package com.pablogd.mvvmexample.app.utils;

/**
 * CustomRuntimeException
 * Created by pablogutierrez on 16/12/18.
 */
public class CustomRuntimeException extends RuntimeException {

    /**
     * Constructor
     */
    public CustomRuntimeException() {
        //Empty constructor
    }

    /**
     * Constructor
     *
     * @param message message
     */
    public CustomRuntimeException(final String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param message message
     * @param cause   cause throwable
     */
    public CustomRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor
     *
     * @param cause cause throwable
     */
    public CustomRuntimeException(final Throwable cause) {
        super(cause);
    }

}
