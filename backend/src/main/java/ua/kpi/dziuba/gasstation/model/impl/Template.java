package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.ITemplate;

import javax.persistence.*;

@Entity(name = "templates")
public class Template implements ITemplate {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private User userList;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    private Tariff tariffList;

    public Template() {
    }

    public Integer getId() {
        return id;
    }

    public User getUserList() {
        return userList;
    }

    public Tariff getTariffList() {
        return tariffList;
    }
}
