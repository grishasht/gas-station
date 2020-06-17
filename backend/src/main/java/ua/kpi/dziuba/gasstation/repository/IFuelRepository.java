package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.impl.Fuel;

/**
 * Репозиторій, який відповідає за маніпуляцію таблицею і сутністю пального в базі даних -
 * CRUD - операції.
 */
@Component
public interface IFuelRepository extends CrudRepository<Fuel, Integer> {

}
