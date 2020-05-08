package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.impl.Fuel;

public class FuelBuilder {
    private Integer id;
    private String type;
    private String name;
    private Float price;

    FuelBuilder(){

    }

    public static FuelBuilder newBuilder(){
        return new FuelBuilder();
    }

    public FuelBuilder setType(String type) {
        this.type = type;

        return this;
    }

    public FuelBuilder setId(Integer id) {
        this.id = id;

        return this;
    }

    public FuelBuilder setPrice(Float price) {
        this.price = price;

        return this;
    }

    public FuelBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public Fuel build(){
        return new Fuel(id, type, name, price);
    }
}
