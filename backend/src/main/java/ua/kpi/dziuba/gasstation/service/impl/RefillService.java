package ua.kpi.dziuba.gasstation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.dziuba.gasstation.model.IRefill;
import ua.kpi.dziuba.gasstation.model.impl.Refill;
import ua.kpi.dziuba.gasstation.repository.IRefillRepository;
import ua.kpi.dziuba.gasstation.service.IRefillService;

import java.util.List;
import java.util.UUID;

public class RefillService implements IRefillService {

    @Autowired
    private IRefillRepository refillRepository;

    @Override
    public List<IRefill> getAllRefills(UUID userGuid) {

        return refillRepository.findAllByUserGuid(userGuid);
    }

    @Override
    public Refill createNewRefill(Refill refill) {

        return refillRepository.save(refill);
    }
}
