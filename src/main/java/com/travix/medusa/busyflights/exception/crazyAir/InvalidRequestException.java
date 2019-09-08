package com.travix.medusa.busyflights.exception.crazyAir;

/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(final String message) {
        super(message);
    }
}
