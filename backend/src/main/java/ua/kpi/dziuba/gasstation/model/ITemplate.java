package ua.kpi.dziuba.gasstation.model;

import ua.kpi.dziuba.gasstation.model.impl.Fuel;

import java.util.UUID;

public interface ITemplate {
    Integer getId();

    UUID getUserGuid();

    Fuel getFuel();

    String getName();
}
