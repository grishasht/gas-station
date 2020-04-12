package ua.kpi.dziuba.gasstation.gstation.model.impl;

import ua.kpi.dziuba.gasstation.gstation.model.IFuel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
