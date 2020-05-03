package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.impl.Refill;

public class RefillBuilder {

    RefillBuilder() {
    }

    public static RefillBuilder newBuilder(){
        return new RefillBuilder();
    }

    public Refill build(){
        return new Refill();
    }
}
