package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.impl.User;

import java.util.UUID;

public class UserBuilder {
    private Integer id;
    private UUID guid;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private String city;

    UserBuilder(){

    }

    public static UserBuilder newBuilder(){
        return new UserBuilder();
    }

    public UserBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserBuilder setGuid(UUID guid) {
        this.guid = guid;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public UserBuilder setSurname(String surname) {
        this.surname = surname;

        return this;
    }

    public UserBuilder setLogin(String login) {
        this.login = login;

        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;

        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;

        return this;
    }

    public UserBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public User build(){
        return new User(id, guid, name, surname, login, password, email, city);
    }
}
