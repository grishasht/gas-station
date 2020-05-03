package ua.kpi.dziuba.gasstation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import ua.kpi.dziuba.gasstation.exception.GasStationException;
import ua.kpi.dziuba.gasstation.exception.InvalidUserDataException;
import ua.kpi.dziuba.gasstation.model.impl.Error;

@RestController
public class ExceptionController {

    private static final String ERROR_MSG_404 = "Page not found!";
    private static final String ERROR_MSG_400 = "Bad request!";
    private static final String ERROR_MSG_401 = "Unauthorized! Access denied";
    private static final String ERROR_MSG_403 = "Access forbidden!";

    @ExceptionHandler(Exception.class)
    public Error handleException(){
        return new Error();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Error handleAccessDeniedError(Exception ex, WebRequest request){
        return new Error(HttpStatus.FORBIDDEN.value(), ERROR_MSG_403);
    }

    @ExceptionHandler(InvalidUserDataException.class)
    public Error handleInvalidDataException(Exception ex, WebRequest request){
        return new Error(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
    }

}
