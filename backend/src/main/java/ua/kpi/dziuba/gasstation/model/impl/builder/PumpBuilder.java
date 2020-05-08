package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.IPump;
import ua.kpi.dziuba.gasstation.model.impl.Fuel;
import ua.kpi.dziuba.gasstation.model.impl.Pump;

import java.util.List;

public class PumpBuilder {
    private Integer id;
    private Integer idLocal;
    private List<Fuel> fuelList;
    private String city;
    private String nameStation;

    public static PumpBuilder newBuilder(){
        return new PumpBuilder();
    }

    public PumpBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public PumpBuilder setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
        return this;
    }

    public PumpBuilder setFuelList(List<Fuel> fuelList) {
        this.fuelList = fuelList;
        return this;
    }

    public PumpBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public PumpBuilder setNameStation(String nameStation) {
        this.nameStation = nameStation;
        return this;
    }

    public IPump build(){
        return new Pump(id, idLocal, fuelList, city, nameStation);
    }
}
