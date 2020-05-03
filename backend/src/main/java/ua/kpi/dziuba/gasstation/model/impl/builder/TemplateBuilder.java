package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.impl.Tariff;
import ua.kpi.dziuba.gasstation.model.impl.Template;

import java.util.UUID;

public class TemplateBuilder {

    private Integer id;
    private UUID userGuid;
    private Tariff tariff;
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

    public TemplateBuilder setTariff(Tariff tariff) {
        this.tariff = tariff;
        return this;
    }

    public TemplateBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Template build(){
        return new Template(id, userGuid, tariff, name);
    }
}
