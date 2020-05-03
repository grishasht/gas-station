package ua.kpi.dziuba.gasstation.model;

import ua.kpi.dziuba.gasstation.model.impl.Tariff;

import java.util.UUID;

public interface ITemplate {
    Integer getId();

    UUID getUserGuid();

    Tariff getTariff();

    String getName();
}
