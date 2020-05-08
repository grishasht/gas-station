package ua.kpi.dziuba.gasstation.model;

import ua.kpi.dziuba.gasstation.model.impl.Fuel;
import ua.kpi.dziuba.gasstation.model.impl.User;

import java.util.List;

public interface IRefill {
    Integer getId();

    List<User> getUserList();

    List<Fuel> getFuelList();
}
