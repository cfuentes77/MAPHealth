package com.thisismap.demo.model;

/**
 * Class <tt>ErrorSeverity</tt>
 */
public enum ErrorSeverity {
    RECOVERABLE,
    USER_FACING,  //Doesn't this imply we need i18n lookup codes?
    USER_HIDDEN,
    FATAL
}
