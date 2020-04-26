package ua.kpi.dziuba.gasstation.gstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.gstation.model.impl.Refill;

@Component
public interface IRefillRepository extends CrudRepository<Refill, Integer> {



}
