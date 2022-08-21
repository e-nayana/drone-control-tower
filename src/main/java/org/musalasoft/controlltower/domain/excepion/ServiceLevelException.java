package org.musalasoft.controlltower.domain.excepion;

public class ServiceLevelException extends RuntimeException{
    public ServiceLevelException() {
    }

    public ServiceLevelException(String message) {
        super(message);
    }

    public ServiceLevelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceLevelException(Throwable cause) {
        super(cause);
    }

    public ServiceLevelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
