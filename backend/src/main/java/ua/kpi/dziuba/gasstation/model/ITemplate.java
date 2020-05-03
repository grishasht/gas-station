package ua.kpi.dziuba.gasstation.model;

import ua.kpi.dziuba.gasstation.model.impl.Tariff;
import ua.kpi.dziuba.gasstation.model.impl.User;

public interface ITemplate {
    Integer getId();

    User getUserList();

    Tariff getTariffList();
}
