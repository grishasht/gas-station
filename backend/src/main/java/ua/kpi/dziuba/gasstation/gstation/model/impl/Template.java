package ua.kpi.dziuba.gasstation.gstation.model.impl;

import ua.kpi.dziuba.gasstation.gstation.model.ITemplate;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

public class Template implements ITemplate {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private List<User> userList;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private List<Tariff> tariffList;

    public Integer getId() {
        return id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Tariff> getTariffList() {
        return tariffList;
    }
}
