package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.IRefill;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "refills")
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
    private List<Fuel> fuelList;

    public Refill() {
    }

    public Integer getId() {
        return id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Fuel> getFuelList() {
        return fuelList;
    }
}
