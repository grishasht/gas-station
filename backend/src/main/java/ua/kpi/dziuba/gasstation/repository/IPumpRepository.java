package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IPump;
import ua.kpi.dziuba.gasstation.model.impl.Pump;

import java.util.List;

@Component
public interface IPumpRepository extends CrudRepository<Pump, Integer> {

    List<IPump> findAllByCityAndNameStation(String city, String nameStation);

    List<IPump> findAllByCity(String city);

    List<IPump> findAllByNameStation(String nameStation);

}
