package com.travix.medusa.busyflights.exception.toughJet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */
@Getter
@RequiredArgsConstructor
public enum ToughJetError {


    TOUGH_JET_BAD_REQUEST("MPS-001", "Bad Request"),
    TOUGH_JET_UNSUPPORTED_METHOD("MPS-002", "Method not allowed"),
    TOUGH_JET_NOT_FOUND("MPS-003", "toughtjet details not found"),
    TOUGH_JET_SERVICE_FAILURE("MPS-004", "toughtjet service failure"),
    SERVICE_FAILURE_MESSAGE_NOT_READABLE("MPS-005", "Message not readable"),
    TOUGH_JET_EXCEPTION("MPS-006", "Oracle Gateway response exception"),
    TOUGH_JET_UNAUTHORISED_FORBIDDEN("MPS-007", "OracleGateway - Unauthorised/Forbidden"),
    UNEXPECTED_ERROR("MPS-008", "Unexpected Error Occurred");

    private final String code;
    private final String message;

    ToughJetError(String s, String s1) {
    }
}