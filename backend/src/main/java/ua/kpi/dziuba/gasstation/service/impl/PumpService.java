package ua.kpi.dziuba.gasstation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.dziuba.gasstation.model.IPump;
import ua.kpi.dziuba.gasstation.model.impl.Pump;
import ua.kpi.dziuba.gasstation.repository.IPumpRepository;
import ua.kpi.dziuba.gasstation.service.IPumpService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PumpService implements IPumpService {

    @Autowired
    private IPumpRepository pumpRepository;

    @Override
    public List<IPump> getAllPumps() {

        final Iterable<Pump> pumpIterable = pumpRepository.findAll();

        return StreamSupport.stream(pumpIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<IPump> getPumpsByCityAndStation(String city, String station) {
        return pumpRepository.findAllByCityAndNameStation(city, station);
    }

    @Override
    public List<IPump> getPumpsByCity(String city) {
        return pumpRepository.findAllByCity(city);
    }

    @Override
    public List<IPump> getPumpsByStation(String station) {
        return pumpRepository.findAllByNameStation(station);
    }
}
