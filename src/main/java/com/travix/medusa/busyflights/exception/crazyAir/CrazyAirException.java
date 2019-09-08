package com.travix.medusa.busyflights.exception.crazyAir;

import lombok.Getter;
import lombok.ToString;
/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */

@ToString(callSuper = true)
@Getter
public class CrazyAirException extends RuntimeException {
    private static final long serialVersionUID = -5259372800839088877L;
    private static final String MESSAGE_TEMPLATE = "%s, error response : %s";

    private final String code;

    public CrazyAirException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}
