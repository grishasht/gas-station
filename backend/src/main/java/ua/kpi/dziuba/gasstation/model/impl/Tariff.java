package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.ITariff;

import javax.persistence.*;

@Entity(name = "tariffs")
public class Tariff implements ITariff {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private Fuel fuelList;
    private Float price;

    public Tariff() {
    }

    public Tariff(Float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public Fuel getFuelList() {
        return fuelList;
    }
}
