package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IRefill;
import ua.kpi.dziuba.gasstation.model.impl.Refill;

import java.util.List;
import java.util.UUID;

@Component
public interface IRefillRepository extends CrudRepository<Refill, Integer> {

    List<IRefill> findAllByUserGuid(UUID userGuid);

}
