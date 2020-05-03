package ua.kpi.dziuba.gasstation.model;

import ua.kpi.dziuba.gasstation.model.impl.Tariff;
import ua.kpi.dziuba.gasstation.model.impl.User;

import java.util.List;

public interface IRefill {
    Integer getId();

    List<User> getUserList();

    List<Tariff> getTariffList();
}
