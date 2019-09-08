package com.travix.medusa.busyflights.domain.toughjet;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirErrorDecoder;
import com.travix.medusa.busyflights.exception.crazyAir.InvalidRequestException;
import com.travix.medusa.busyflights.exception.toughJet.ToughJetException;
import com.travix.medusa.busyflights.exception.toughJet.ToughJetNotFoundException;
import com.travix.medusa.busyflights.exception.toughJet.ToughJetUnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import static com.travix.medusa.busyflights.exception.toughJet.ToughJetError.*;

@Slf4j
public class ToughJetErrorDecoder implements ErrorDecoder {

    /**
     * Create new application exception based on response
     */

    private static final Logger log = LoggerFactory.getLogger(CrazyAirErrorDecoder.class);
    @Override
    public Exception decode(final String methodKey, final Response response) {

        log.error("Unsuccessful request to motor policy API. Response code: [{}], Response [{}]",
                response.status(), response);

        final Exception exception;
        switch (HttpStatus.valueOf(response.status())) {
            case NOT_FOUND:
                exception = new ToughJetNotFoundException(TOUGH_JET_NOT_FOUND.getMessage());
                break;
            case UNAUTHORIZED:
            case FORBIDDEN:
                exception = new ToughJetUnauthorizedException(TOUGH_JET_UNAUTHORISED_FORBIDDEN.getMessage());
                break;
            case BAD_REQUEST:
                exception = new InvalidRequestException(TOUGH_JET_BAD_REQUEST.getMessage());
                break;
            default:
                exception = new ToughJetException(TOUGH_JET_EXCEPTION.getCode(), TOUGH_JET_EXCEPTION.getMessage());
                break;
        }

        return exception;
    }
}

