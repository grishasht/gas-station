package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.IRefill;

import javax.persistence.*;
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
    private Fuel fuel;
    private Float volume;
    private Float finalPrice;

    public Refill() {
    }

    public Refill(Integer id, UUID userGuid, Fuel fuel, Float volume, Float finalPrice) {
        this.id = id;
        this.userGuid = userGuid;
        this.fuel = fuel;
        this.volume = volume;
        this.finalPrice = finalPrice;
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
}
