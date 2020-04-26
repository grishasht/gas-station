package ua.kpi.dziuba.gasstation.gstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.gstation.model.impl.Tariff;

@Component
public interface ITariffRepository extends CrudRepository<Tariff, Integer> {



}
