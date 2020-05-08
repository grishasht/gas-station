package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.impl.Fuel;
import ua.kpi.dziuba.gasstation.model.impl.Refill;

import java.util.UUID;

public class RefillBuilder {
    private Integer id;
    private UUID userGuid;
    private Fuel fuel;
    private Float volume;
    private Float finalPrice;

    RefillBuilder() {
    }

    public static RefillBuilder newBuilder(){
        return new RefillBuilder();
    }

    public RefillBuilder setId(Integer id) {
        this.id = id;

        return this;
    }

    public RefillBuilder setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;

        return this;
    }

    public RefillBuilder setFuel(Fuel fuel) {
        this.fuel = fuel;

        return this;
    }

    public RefillBuilder setVolume(Float volume) {
        this.volume = volume;

        return this;
    }

    public RefillBuilder setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;

        return this;
    }

    public Refill build(){
        return new Refill(id, userGuid, fuel, volume, finalPrice);
    }
}
