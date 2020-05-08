package ua.kpi.dziuba.gasstation.service;

import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IPump;

import java.util.List;

@Component
public interface IPumpService {

    List<IPump> getAllPumps();

    List<IPump> getPumpsByCityAndStation(String city, String station);

    List<IPump> getPumpsByCity(String city);

    List<IPump> getPumpsByStation(String station);

}
