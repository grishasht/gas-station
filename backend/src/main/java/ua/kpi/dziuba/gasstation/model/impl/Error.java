package ua.kpi.dziuba.gasstation.model.impl;

import java.util.Objects;

public class Error {

    private Integer statusCode;
    private String message;

    public Error() {
    }

    public Error(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Error(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Error! " +
                "statusCode: " + statusCode +
                ", " + message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equals(getStatusCode(), error.getStatusCode()) &&
                Objects.equals(getMessage(), error.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusCode(), getMessage());
    }
}
