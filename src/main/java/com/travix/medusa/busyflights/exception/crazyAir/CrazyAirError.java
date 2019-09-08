package com.travix.medusa.busyflights.exception.crazyAir;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */
@Getter
@RequiredArgsConstructor
public enum CrazyAirError {


    CRAZY_AIR_BAD_REQUEST("MPS-001", "Bad Request"),
    CRAZY_AIR_UNSUPPORTED_METHOD("MPS-002", "Method not allowed"),
    CRAZY_AIR_NOT_FOUND("MPS-003", "crazyair details not found"),
    CRAZY_AIR_SERVICE_FAILURE("MPS-004", "crazyair service failure"),
    SERVICE_FAILURE_MESSAGE_NOT_READABLE("MPS-005", "Message not readable"),
    CRAZY_AIR_EXCEPTION("MPS-006", "Oracle Gateway response exception"),
    CRAZY_AIR_UNAUTHORISED_FORBIDDEN("MPS-007", "OracleGateway - Unauthorised/Forbidden"),
    UNEXPECTED_ERROR("MPS-008", "Unexpected Error Occurred");

    private final String code;
    private final String message;
}