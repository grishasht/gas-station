package ua.kpi.dziuba.gasstation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import ua.kpi.dziuba.gasstation.exception.InvalidUserDataException;
import ua.kpi.dziuba.gasstation.model.impl.Error;

@RestController
public class ExceptionController {

    private static final String ERROR_MSG_404 = "Page not found!";
    private static final String ERROR_MSG_400 = "Bad request!";
    private static final String ERROR_MSG_401 = "Unauthorized! Access denied";
    private static final String ERROR_MSG_403 = "Access forbidden!";

    /**
     * Метод, що обробляє всі помилки, які виникли під час роботи сервервера та які
     * не були обробленими іншими методами-обробниками.
     * @return помилку із загальним повідомленням у вигляді JSON.
     */
    @ExceptionHandler(Exception.class)
    public Error handleException(){
        return new Error();
    }

    /**
     * Метод, який обробляє помилки, які зв'язані із забороненням доступу до ресурсів серверу.
     * @return помилку з повідомленням про заборону доступу до ресурсів серверу у вигляді JSON.
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Error handleAccessDeniedError(Exception ex, WebRequest request){
        return new Error(HttpStatus.FORBIDDEN.value(), ERROR_MSG_403);
    }


    /**
     * Метод, який обробляє помилки, які зв'язані із валідністю даних.
     * Дана помилка з'являється коли користувач відправив в тілі реквеста невалідні дані для
     * входу в систему. Тобто коли дані не відповідають умовам які встановлені на сервері.
     *    Умови:
     *      - адреса електронної почти (регулярний вираз): \\S{4,25}@\\w{1,10}.\\w{1,4}
     *          Відправлена електронна почта має бути у вигляді:
     *          1. від 4-х до 25-ти друкованих символів, таких як букви, цифри та знаки типу: -, _, ₴ і тд. ;
     *          2. символ електронної адреси: @ ;
     *          3. набір друкованих символів букв довжиною від 1 до 10 символів ;
     *          4. роздільник адресу домену: . ;
     *          5. набір символів букв довжиною від 1 до 4 символів
     *
     *      - логін (регулярний вираз): \\S{4,20}
     *          Відправлений логін має бути у вигляді набору символів довжиною від 4 до 20 друкованих символів:
     *          букв, цифр, спеціальних символів таких як -, _, %, "
     *
     *      - пароль (регулярний вираз): ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$
     *          Відправлений пароль має обов'язково складатися хоча б із однієї букви верхнього регістру,
     *          однієї букви нижнього регістру, цифри та спеціального знаку та бути довжиною мінімум 6 символів.
     *
     * @return помилку з повідомленням про невалідність введених даних та заборону доступу до ресурсів серверу у вигляді JSON.
     * Також у повідомлення входить інформація про те які саме дані не валідні.
     */
    @ExceptionHandler(InvalidUserDataException.class)
    public ResponseEntity<Error> handleInvalidDataException(Exception ex, WebRequest request){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new Error(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage()));

    }

}
