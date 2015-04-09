package com.thisismap.demo.model;

/**
 * Class <tt>ErrorResponse</tt>
 */
public enum ErrorResponse {
    GENERAL_ERROR(1000, "A general error has occurred {0}", ErrorSeverity.USER_HIDDEN),
    VALIDATION_ERROR(1001, "There was one or more validation error(s)", ErrorSeverity.USER_FACING),
    LOGIN_FAILED(1002, "Login attempt has failed", ErrorSeverity.USER_FACING),
    NOT_LOGGED_IN(1003, "User is not logged in", ErrorSeverity.USER_FACING),
    ACCESS_DENIED(1004, "User does not have access to selected resource", ErrorSeverity.USER_FACING),
    INVALID_ARGUMENT(1005, "An argument received was invalid {0}", ErrorSeverity.USER_FACING),
    METHOD_NOT_AVAILABLE(1009, "The method invoked is not supported.", ErrorSeverity.USER_HIDDEN),
    ENTITY_NOT_FOUND(1010, "The requested entity could not be found", ErrorSeverity.USER_HIDDEN),
    CURRENT_PASSWORD_DOES_NOT_MATCH(1011, "The current password entered does not match for this user.", ErrorSeverity.USER_FACING),
    API_ACCESS_DENIED(1012, "Failed to provide correctly signed message. Verify signature is created according to the API documentation.", ErrorSeverity.USER_HIDDEN),
    CONFIGURATION_ERROR(1013, "There was a problem with the applications configuration. Contact admin or devs.", ErrorSeverity.USER_HIDDEN),

    API_GENERAL_ERROR(2001, "There was an error during execution of request.", ErrorSeverity.FATAL);

    int code;
    String errorText;
    ErrorSeverity severity;

    private ErrorResponse(int code, String errorText, ErrorSeverity severity) {
        this.code = code;
        this.errorText = errorText;
        this.severity = severity;
    }

    public String toString() {
        return this.errorText;
    }
}
