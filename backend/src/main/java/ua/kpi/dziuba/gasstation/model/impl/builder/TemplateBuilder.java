package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.impl.Fuel;
import ua.kpi.dziuba.gasstation.model.impl.Template;

import java.util.UUID;

public class TemplateBuilder {

    private Integer id;
    private UUID userGuid;
    private Fuel fuel;
    private String name;

    TemplateBuilder() {
    }

    public static TemplateBuilder newBuilder(){
        return new TemplateBuilder();
    }

    public TemplateBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public TemplateBuilder setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;
        return this;
    }

    public TemplateBuilder setFuel(Fuel fuel) {
        this.fuel = fuel;
        return this;
    }

    public TemplateBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Template build(){
        return new Template(id, userGuid, fuel, name);
    }
}
