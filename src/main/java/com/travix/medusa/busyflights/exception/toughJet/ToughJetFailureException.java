package com.travix.medusa.busyflights.exception.toughJet;

/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */
public class ToughJetFailureException extends RuntimeException {

    public ToughJetFailureException(final String message) {
        super(message);
    }

    public ToughJetFailureException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
