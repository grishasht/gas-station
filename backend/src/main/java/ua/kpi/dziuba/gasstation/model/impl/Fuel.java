package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.IFuel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "fuels")
public class Fuel implements IFuel {
    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String name;
    private Float price;

    public Fuel(Integer id, String type, String name, Float price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public Fuel() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Float getPrice() {
        return price;
    }
}
