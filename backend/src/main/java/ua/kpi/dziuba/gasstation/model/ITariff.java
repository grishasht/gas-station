package ua.kpi.dziuba.gasstation.model;

import ua.kpi.dziuba.gasstation.model.impl.Fuel;

public interface ITariff {
    Integer getId();

    Fuel getFuelList();

    Float getPrice();
}
