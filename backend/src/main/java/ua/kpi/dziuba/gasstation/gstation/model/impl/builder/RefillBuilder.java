package ua.kpi.dziuba.gasstation.gstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.gstation.model.IRefill;
import ua.kpi.dziuba.gasstation.gstation.model.impl.Refill;

public class RefillBuilder {

    RefillBuilder() {
    }

    public static RefillBuilder newBuilder(){
        return new RefillBuilder();
    }

    public IRefill build(){
        return new Refill();
    }
}
