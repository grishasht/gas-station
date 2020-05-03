package ua.kpi.dziuba.gasstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dziuba.gasstation.model.IFuel;
import ua.kpi.dziuba.gasstation.model.impl.Fuel;
import ua.kpi.dziuba.gasstation.repository.IFuelRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class FuelController {
    public static final Logger LOGGER = LoggerFactory.getLogger(FuelController.class);

    private final IFuelRepository fuelRepository;

    @Autowired
    public FuelController(IFuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    @GetMapping("**/fuels")
    public List<IFuel> getAllFuelList() {

        final Iterable<Fuel> allFuelIterator = fuelRepository.findAll();

        final List<IFuel> allFuelList = StreamSupport.stream(allFuelIterator.spliterator(), false)
                .map(IFuel.class::cast)
                .collect(Collectors.toList());

        LOGGER.info("All fuels retrieved from the database");

        return allFuelList;
    }

}
