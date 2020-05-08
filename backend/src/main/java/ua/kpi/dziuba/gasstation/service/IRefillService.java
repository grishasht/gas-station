package ua.kpi.dziuba.gasstation.service;

import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IRefill;
import ua.kpi.dziuba.gasstation.model.impl.Refill;

import java.util.List;
import java.util.UUID;

@Component
public interface IRefillService {

    List<IRefill> getAllRefills(UUID userGuid);

    IRefill createNewRefill(Refill refill);
}
