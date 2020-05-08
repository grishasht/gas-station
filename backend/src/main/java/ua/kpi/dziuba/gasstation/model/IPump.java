package ua.kpi.dziuba.gasstation.model;

import ua.kpi.dziuba.gasstation.model.impl.Fuel;

import java.util.List;

public interface IPump {

    Integer getId();

    Integer getIdLocal();

    List<Fuel> getFuelList();

    String getCity();

    String getNameStation();

}
