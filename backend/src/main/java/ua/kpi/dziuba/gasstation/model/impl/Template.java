package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.ITemplate;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "templates")
public class Template implements ITemplate {
    @Id
    @GeneratedValue
    private Integer id;
    private UUID userGuid;
    @OneToOne(
            cascade = CascadeType.ALL
    )
    private Tariff tariff;
    private String name;

    public Template() {
    }

    public Template(Integer id, UUID userGuid, Tariff tariff, String name) {
        this.id = id;
        this.userGuid = userGuid;
        this.tariff = tariff;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public UUID getUserGuid() {
        return this.userGuid;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }

    @Override
    public String getName() {
        return name;
    }
}
