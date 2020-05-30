package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.IRefill;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "refills")
public class Refill implements IRefill {
    @Id
    @GeneratedValue
    private Integer id;
    private UUID userGuid;
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_fuel")
    private Fuel fuel;
    private Timestamp dateSubmitted;
    private Float volume;
    private Float finalPrice;
    private String city;
    private String nameStation;

    public Refill() {
    }

    public Refill(Integer id, UUID userGuid, Fuel fuel, Timestamp dateSubmitted, Float volume, Float finalPrice, String city, String nameStation) {
        this.id = id;
        this.userGuid = userGuid;
        this.fuel = fuel;
        this.dateSubmitted = dateSubmitted;
        this.volume = volume;
        this.finalPrice = finalPrice;
        this.city = city;
        this.nameStation = nameStation;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public UUID getUserGuid() {
        return userGuid;
    }

    @Override
    public Fuel getFuel() {
        return fuel;
    }

    @Override
    public Float getVolume() {
        return volume;
    }

    @Override
    public Float getFinalPrice() {
        return finalPrice;
    }

    @Override
    public Timestamp getDateSubmitted() {
        return dateSubmitted;
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
