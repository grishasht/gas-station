package ua.kpi.dziuba.gasstation.gstation.model;

import ua.kpi.dziuba.gasstation.gstation.model.impl.Fuel;

import java.util.List;

public interface ITariff {
    Integer getId();

    Fuel getFuelList();

    Float getPrice();
}
