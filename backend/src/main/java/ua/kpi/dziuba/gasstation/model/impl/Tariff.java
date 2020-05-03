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
    @JoinColumn(name = "id_fuel")
    private Fuel fuel;
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

    public Fuel getFuel() {
        return fuel;
    }
}
