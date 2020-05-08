package ua.kpi.dziuba.gasstation.model;

import java.util.UUID;

public interface IUser {
    Integer getId();

    UUID getGuid();

    String getName();

    String getSurname();

    String getLogin();

    String getPassword();

    String getEmail();

    String getCity();
}