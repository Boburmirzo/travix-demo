package com.travix.medusa.busyflights.exception.crazyAir;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */
@ControllerAdvice
@Slf4j
public class CrazyAirServiceFailureExceptionHandler {

    private String version;

    @Autowired
    public CrazyAirServiceFailureExceptionHandler(@Value("${application.version}") final String version) {
        this.version = version;
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    @ResponseBody
    protected CrazyAirResponse handle(final CrazyAirFailureException exception) {
        log.error("ToughJetFailureException: {}", exception.getMessage(), exception);
        return buildServiceError(CrazyAirError.CRAZY_AIR_SERVICE_FAILURE);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler
    @ResponseBody
    protected CrazyAirResponse handle(final CrazyAirNotFoundException exception) {
        log.error("ToughJetNotFoundException: {}", exception.getMessage(), exception);
        return buildServiceError(CrazyAirError.CRAZY_AIR_NOT_FOUND);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler
    @ResponseBody
    protected CrazyAirResponse handle(final IllegalArgumentException exception) {
        log.error("IllegalArgumentException: {}", exception.getMessage(), exception);
        return buildServiceError(CrazyAirError.CRAZY_AIR_BAD_REQUEST);
    }

    @ResponseStatus(OK)
    @ExceptionHandler
    @ResponseBody
    protected CrazyAirResponse handle(final CrazyAirException exception) {
        log.error("ToughJetException: {}", exception.getMessage(), exception);
        return buildServiceError(CrazyAirError.CRAZY_AIR_EXCEPTION);
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    @ResponseBody
    protected CrazyAirResponse handle(final Exception exception) {
        log.error("Exception: {}", exception.getMessage(), exception);
        return buildServiceError(CrazyAirError.UNEXPECTED_ERROR);
    }

    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler
    @ResponseBody
    protected CrazyAirResponse handle(final CrazyAirUnauthorizedException exception) {
        log.error("MotorPolicyUnauthorisedException: {}", exception.getMessage(), exception);
        return buildServiceError(CrazyAirError.CRAZY_AIR_UNAUTHORISED_FORBIDDEN);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler
    @ResponseBody
    protected CrazyAirResponse handle(final InvalidRequestException exception) {
        log.error("InvalidRequestException: {}", exception.getMessage(), exception);
        return buildServiceError(CrazyAirError.CRAZY_AIR_BAD_REQUEST);
    }

//    @ResponseStatus(BAD_REQUEST)
//    @ExceptionHandler
//    @ResponseBody
//    public CrazyAirResponse handle(final ConstraintViolationException exception) {
//        final List<ErrorInfo> errors = exception.getConstraintViolations()
//                                                .stream()
//                                                .map(this::getErrorMessage)
//                                                .collect(Collectors.toCollection(ArrayList::new));
//        return new CrazyAirResponse()
//                .apiVersion(version)
//                .errors(errors)
//                .infos(Collections.emptyList())
//                .results(Collections.emptyList());
//    }

//    @ResponseStatus(BAD_REQUEST)
//    @ExceptionHandler
//    @ResponseBody
//    public CrazyAirResponse handle(final MethodArgumentTypeMismatchException exception) {
//        log.error("MethodArgumentTypeMismatchException: {}", exception.getMessage(), exception);
//        return buildServiceError(exception);
//    }

//    @ResponseStatus(METHOD_NOT_ALLOWED)
//    @ExceptionHandler
//    @ResponseBody
//    public CrazyAirResponse handle(final HttpRequestMethodNotSupportedException exception) {
//        log.error("HttpRequestMethodNotSupportedException: {}", exception.getMessage(), exception);
//        return buildServiceError(ToughJetError.CRAZY_AIR_UNSUPPORTED_METHOD);
//    }

//    @ResponseStatus(BAD_REQUEST)
//    @ExceptionHandler
//    @ResponseBody
//    protected CrazyAirResponse handle(final HttpMessageNotReadableException exception) {
//        log.error("HttpMessageNotReadableException: {}", exception.getMessage(), exception);
//        return buildServiceError(ToughJetError.SERVICE_FAILURE_MESSAGE_NOT_READABLE);
//    }

    private CrazyAirResponse buildServiceError(final CrazyAirError motorPolicyError) {
        return new CrazyAirResponse();

    }
//
//    private CrazyAirResponse buildServiceError(final ToughJetException exception) {
//        return new CrazyAirResponse()
//                .apiVersion(version)
//                .addErrorsItem(new ErrorInfo().code(exception.getCode()).message(exception.getMessage()).traceId(getTraceId()))
//                .infos(Collections.emptyList())
//                .results(Collections.emptyList());
//    }
//
//    private CrazyAirResponse buildServiceError(final MethodArgumentTypeMismatchException exception) {
//        return new CrazyAirResponse()
//                .apiVersion(version)
//                .addErrorsItem(new ErrorInfo().code(ToughJetError.CRAZY_AIR_BAD_REQUEST.getCode()).message(ToughJetError.CRAZY_AIR_BAD_REQUEST.getMessage() + " - " + exception.getMessage()).traceId(getTraceId()))
//                .infos(Collections.emptyList())
//                .results(Collections.emptyList());
//    }
//
//    private ErrorInfo getErrorMessage(final ConstraintViolation<?> error) {
//        final String field = ((PathImpl) error.getPropertyPath()).getLeafNode().getName();
//        final String errorMessage = "Field " + field + " " + error.getMessage();
//        return new ErrorInfo().code(ToughJetError.CRAZY_AIR_BAD_REQUEST.getCode()).message(errorMessage).traceId(getTraceId());
//    }
//
//    private String getTraceId() {
//        return MDC.get("X-B3-TraceId");
//    }
}
