package com.thisismap.demo.model;

import java.io.Serializable;

/**
 * Class <tt>ApiResponse</tt>
 */
public class ApiResponse implements Serializable {
	
	private static final long serialVersionUID = -9059681500448498172L;
	
	public ResponseType responseType;
    public ErrorDetail errorDetail;
    public Object returnObject;


    /**
     * * add ErrorSeverity enum
     * * add error code
     * * all three are stuck in Error Enum
     */
    public ApiResponse(ResponseType responseType, ErrorResponse errorDetail, Object returnObject) {
        this.responseType = responseType;
        this.returnObject = returnObject;
        createErrorResponse(errorDetail);
    }

    private void createErrorResponse(ErrorResponse errorDetail) {
        if (errorDetail != null) {
            ErrorDetail error = new ErrorDetail();
            error.code = errorDetail.code;
            error.errorText = errorDetail.errorText;
            error.severity = errorDetail.severity;

            this.errorDetail = error;
        }
    }

    class ErrorDetail {
        public int code;
        public String errorText;
        public ErrorSeverity severity;
    }
}
