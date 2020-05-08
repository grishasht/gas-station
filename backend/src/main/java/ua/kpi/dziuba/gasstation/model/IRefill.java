package ua.kpi.dziuba.gasstation.model;

import ua.kpi.dziuba.gasstation.model.impl.Fuel;

import java.util.UUID;

public interface IRefill {
    Integer getId();

    UUID getUserGuid();

    Fuel getFuel();

    Float getVolume();

    Float getFinalPrice();
}
