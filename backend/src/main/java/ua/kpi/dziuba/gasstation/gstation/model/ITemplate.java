package ua.kpi.dziuba.gasstation.gstation.model;

import ua.kpi.dziuba.gasstation.gstation.model.impl.Tariff;
import ua.kpi.dziuba.gasstation.gstation.model.impl.User;

import java.util.List;

public interface ITemplate {
    Integer getId();

    List<User> getUserList();

    List<Tariff> getTariffList();
}
