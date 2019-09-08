package com.travix.medusa.busyflights.exception.crazyAir;

import lombok.Getter;
/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */
@Getter
public class CrazyAirUnauthorizedException extends RuntimeException {

    public CrazyAirUnauthorizedException(final String message) {
        super(message);
    }
}
