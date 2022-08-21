package org.musalasoft.controlltower.domain.excepion;

public class DroneStateEngineException extends RuntimeException{
    public DroneStateEngineException() {
    }

    public DroneStateEngineException(String message) {
        super(message);
    }

    public DroneStateEngineException(String message, Throwable cause) {
        super(message, cause);
    }

    public DroneStateEngineException(Throwable cause) {
        super(cause);
    }

    public DroneStateEngineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
