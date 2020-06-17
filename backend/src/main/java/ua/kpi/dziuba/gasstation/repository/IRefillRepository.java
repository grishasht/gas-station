package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IRefill;
import ua.kpi.dziuba.gasstation.model.impl.Refill;

import java.util.List;
import java.util.UUID;

/**
 * Репозиторій, який відповідає за маніпуляцію таблицею і сутністю колонок
 * з пальним в базі даних - CRUD - операції.
 */
@Component
public interface IRefillRepository extends CrudRepository<Refill, Integer> {

    /**
     * Метод який витягує з бази даних історію заправок по параметру
     * унікального ідентифікатора користувача.
     *
     * @param userGuid - унікальний ідентифікатор користувача по якому
     *                 будуть витягуватися дані
     * @return список вилучених попередніх заправок, тобто історії заправок
     * по вказаним параметрам
     */
    List<IRefill> findAllByUserGuid(UUID userGuid);

}
