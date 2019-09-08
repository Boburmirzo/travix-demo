package com.travix.medusa.busyflights.exception.crazyAir;


/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */
public class CrazyAirFailureException extends RuntimeException {

    public CrazyAirFailureException(final String message) {
        super(message);
    }

    public CrazyAirFailureException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
