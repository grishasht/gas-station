package ua.kpi.dziuba.gasstation.service;

import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IFuel;

import java.util.List;

@Component
public interface IFuelService {

    List<IFuel> getAllFuels();

}
