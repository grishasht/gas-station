package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IPump;
import ua.kpi.dziuba.gasstation.model.impl.Pump;

import java.util.List;

/**
 * Репозиторій, який відповідає за маніпуляцію таблицею і сутністю колонок
 *  з пальним в базі даних - CRUD - операції.
 */
@Component
public interface IPumpRepository extends CrudRepository<Pump, Integer> {

    /**
     * Метод який витягує з бази даних колонки з пальним по параметрах
     * назви міста та імені станції.
     *
     * @param city - ім'я міста по якому будуть витягуватися дані
     * @param nameStation - назва станції по якомій будуть витягуватися дані
     * @return список вилучених колонок з пальним по вказаним параметрам
     */
    List<IPump> findAllByCityAndNameStation(String city, String nameStation);

    /**
     * Метод який витягує з бази даних колонки з пальним по параметру
     * назви міста.
     *
     * @param city - ім'я міста по якому будуть витягуватися дані
     * @return список вилучених колонок з пальним по вказаним параметрам
     */
    List<IPump> findAllByCity(String city);


    /**
     * Метод який витягує з бази даних колонки з пальним по параметру
     * імені станції.
     *
     * @param nameStation - назва станції по якомій будуть витягуватися дані
     * @return список вилучених колонок з пальним по вказаним параметрам
     */
    List<IPump> findAllByNameStation(String nameStation);

}
