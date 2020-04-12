package ua.kpi.dziuba.gasstation.gstation.model.impl;

import ua.kpi.dziuba.gasstation.gstation.model.ITariff;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

public class Tariff implements ITariff {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private List<Fuel> fuelList;
    private Float price;

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
    public List<Fuel> getFuelList() {
        return fuelList;
    }
}
