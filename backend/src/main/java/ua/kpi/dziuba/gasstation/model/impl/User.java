package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.IUser;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User implements IUser {
    @Id
    @GeneratedValue
    private Integer id;
    private UUID guid;
    private String name;
    private String surname;
    private String login;
    @Column(name = "password_hash")
    private String password;
    private String email;
    private String city;

    public User(Integer id, UUID guid, String name, String surname, String login, String password, String email, String city) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
        this.city = city;
    }

    public User(String name, String surname, String login, String email, String city) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.city = city;
    }

    public User() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public UUID getGuid() {
        return guid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getCity() {
        return city;
    }
}
