package ua.kpi.dziuba.gasstation.gstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.gstation.model.IUser;
import ua.kpi.dziuba.gasstation.gstation.model.impl.User;

import java.util.UUID;

public class UserBuilder {
    private UUID guid;
    private String name;
    private String surname;
    private String login;
    private String passwordHash;
    private String email;

    UserBuilder(){

    }

    public static UserBuilder newBuilder(){
        return new UserBuilder();
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

    public UserBuilder setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;

        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;

        return this;
    }

    public IUser build(){
        return new User(name, surname, login, passwordHash, email);
    }
}
