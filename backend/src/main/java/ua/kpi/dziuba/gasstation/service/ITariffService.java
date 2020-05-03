package ua.kpi.dziuba.gasstation.service;

import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.ITariff;

import java.util.List;

@Component
public interface ITariffService {

    List<ITariff> getAllTariffs();

}
