package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.impl.Fuel;

public class FuelBuilder {
    private String type;
    private String name;

    FuelBuilder(){

    }

    public static FuelBuilder newBuilder(){
        return new FuelBuilder();
    }

    public FuelBuilder setType(String type) {
        this.type = type;

        return this;
    }

    public FuelBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public Fuel build(){
        return new Fuel(type, name);
    }
}
