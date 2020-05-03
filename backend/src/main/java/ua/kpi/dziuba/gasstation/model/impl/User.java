package ua.kpi.dziuba.gasstation.model.impl;

import ua.kpi.dziuba.gasstation.model.IUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "users")
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

    public User(Integer id, UUID guid, String name, String surname, String login, String password, String email) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public UUID getGuid() {
        return guid;
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

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
