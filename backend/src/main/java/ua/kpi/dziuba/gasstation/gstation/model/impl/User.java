package ua.kpi.dziuba.gasstation.gstation.model.impl;

import ua.kpi.dziuba.gasstation.gstation.model.IUser;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User implements IUser {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String passwordHash;
    private String email;

    public User(String name, String surname, String login, String passwordHash, String email) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.passwordHash = passwordHash;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

}
