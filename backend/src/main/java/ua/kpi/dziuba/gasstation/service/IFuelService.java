package ua.kpi.dziuba.gasstation.service;

import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IFuel;

import java.util.List;

/**
 * Клас - сервіс, який викликається із відповідного контроллера та
 * використовує відповідний репозиторій для своєї роботи.
 */
@Component
public interface IFuelService {

    /**
     * Метод, який викликається з контроллера для обробки запиту клієнта
     * на видачу списку пального. Вилучає все пальне із бази даних
     *
     * @return список пального із бази даних.
     */
    List<IFuel> getAllFuels();

}
