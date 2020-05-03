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

    public Fuel(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public Fuel() {
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
