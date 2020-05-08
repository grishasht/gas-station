package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.IPump;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pumps")
public class Pump implements IPump {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer idLocal;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_pump")
    private List<Fuel> fuelList;
    private String city;
    private String nameStation;

    public Pump() {
    }

    public Pump(Integer id, Integer idLocal, List<Fuel> fuelList, String city, String nameStation) {
        this.id = id;
        this.idLocal = idLocal;
        this.fuelList = fuelList;
        this.city = city;
        this.nameStation = nameStation;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getIdLocal() {
        return idLocal;
    }

    @Override
    public List<Fuel> getFuelList() {
        return fuelList;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getNameStation() {
        return nameStation;
    }
}
