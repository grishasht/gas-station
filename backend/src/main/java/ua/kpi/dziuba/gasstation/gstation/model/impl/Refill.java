package ua.kpi.dziuba.gasstation.gstation.model.impl;

import ua.kpi.dziuba.gasstation.gstation.model.IRefill;

import javax.persistence.*;
import java.util.List;

@Entity(name = "refills")
public class Refill implements IRefill {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<User> userList;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Tariff> tariffList;

    public Refill() {
    }

    public Integer getId() {
        return id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Tariff> getTariffList() {
        return tariffList;
    }
}
