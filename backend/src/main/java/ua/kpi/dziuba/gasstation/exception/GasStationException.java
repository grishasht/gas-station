package ua.kpi.dziuba.gasstation.exception;

public class GasStationException extends RuntimeException{

    public GasStationException() {
    }

    public GasStationException(String message) {
        super(message);
    }

    public GasStationException(String message, Throwable cause) {
        super(message, cause);
    }
}
