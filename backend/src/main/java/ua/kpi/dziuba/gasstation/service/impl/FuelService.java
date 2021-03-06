package ua.kpi.dziuba.gasstation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IFuel;
import ua.kpi.dziuba.gasstation.model.impl.Fuel;
import ua.kpi.dziuba.gasstation.repository.IFuelRepository;
import ua.kpi.dziuba.gasstation.service.IFuelService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class FuelService implements IFuelService {

    @Autowired
    private IFuelRepository fuelRepository;

    @Override
    public List<IFuel> getAllFuels() {
        final Iterable<Fuel> allFuelIterator = fuelRepository.findAll();

        return StreamSupport.stream(allFuelIterator.spliterator(), false)
                .map(IFuel.class::cast)
                .collect(Collectors.toList());
    }

}
