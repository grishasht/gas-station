package ua.kpi.dziuba.gasstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dziuba.gasstation.model.IPump;
import ua.kpi.dziuba.gasstation.service.IPumpService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class PumpController {

    public static final Logger LOGGER = LoggerFactory.getLogger(PumpController.class);

    private final IPumpService pumpService;

    @Autowired
    public PumpController(IPumpService pumpService) {
        this.pumpService = pumpService;
    }

    @RequestMapping("{userGuid}/pumps")
    public List<IPump> getAllPumpsByCityAndStation(@PathVariable @Valid UUID userGuid,
                                                   @RequestParam(required = false) String city,
                                                   @RequestParam(required = false) String station) {

        if (city == null && station == null) {
            final List<IPump> allPumps = pumpService.getAllPumps();

            LOGGER.info("All pumps are successfully retrieved!");

            return allPumps;
        } else if (city == null) {
            final List<IPump> pumpsByStation = pumpService.getPumpsByStation(station);

            LOGGER.info("All pumps are retrieved by station {}", station);

            return pumpsByStation;
        } else if (station == null) {
            final List<IPump> pumpsByCity = pumpService.getPumpsByCity(city);

            LOGGER.info("All pumps are retrieved by city {}", city);

            return pumpsByCity;
        }

        final List<IPump> pumpsByCityAndStation = pumpService.getPumpsByCityAndStation(city, station);

        LOGGER.info("All pumps are retrieved by city={} and station={}", city, station);

        return pumpsByCityAndStation;
    }
}
