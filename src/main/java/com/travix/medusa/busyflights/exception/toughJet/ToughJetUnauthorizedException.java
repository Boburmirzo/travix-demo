package com.travix.medusa.busyflights.exception.toughJet;

import lombok.Getter;

/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */
@Getter
public class ToughJetUnauthorizedException extends RuntimeException {

	public ToughJetUnauthorizedException(final String message) {
		super(message);
	}
}
