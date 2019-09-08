package com.travix.medusa.busyflights.domain.crazyair;

import com.travix.medusa.busyflights.exception.crazyAir.CrazyAirException;
import com.travix.medusa.busyflights.exception.crazyAir.CrazyAirNotFoundException;
import com.travix.medusa.busyflights.exception.crazyAir.CrazyAirUnauthorizedException;
import com.travix.medusa.busyflights.exception.crazyAir.InvalidRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import static com.travix.medusa.busyflights.exception.crazyAir.CrazyAirError.*;

/**
 * Wraps the FeignException generated when response status indicates that call was unsuccessful (i.e. status &gt;= 300)
 */
@Slf4j
public class CrazyAirErrorDecoder implements ErrorDecoder {

    /**
     * Create new application exception based on response
     */
    private static final Logger log = LoggerFactory.getLogger(CrazyAirErrorDecoder.class);

    @Override
    public Exception decode(final String methodKey, final Response response) {


        log.error("Unsuccessful request. Response code: [{}], Response [{}]",
                response.status(), response);

        final Exception exception;
        switch (HttpStatus.valueOf(response.status())) {
            case NOT_FOUND:
                exception = new CrazyAirNotFoundException(CRAZY_AIR_NOT_FOUND.getMessage());
                break;
            case UNAUTHORIZED:
            case FORBIDDEN:
                exception = new CrazyAirUnauthorizedException(CRAZY_AIR_UNAUTHORISED_FORBIDDEN.getMessage());
                break;
            case BAD_REQUEST:
                exception = new InvalidRequestException(CRAZY_AIR_BAD_REQUEST.getMessage());
                break;
            default:
                exception = new CrazyAirException(CRAZY_AIR_EXCEPTION.getCode(), CRAZY_AIR_EXCEPTION.getMessage());
                break;
        }

        return exception;
    }
}

