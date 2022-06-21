package com.lindex.customermastergwapi.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerMasterGwException extends RuntimeException {

    private String customizedMessage;
    private String parameter;
    private String value;
    private String details;
    private String code;

    public CustomerMasterGwException() {
    }

    public CustomerMasterGwException(String message) {
        super(message);
    }

    public CustomerMasterGwException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerMasterGwException(Throwable cause) {
        super(cause);
    }

    public CustomerMasterGwException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
