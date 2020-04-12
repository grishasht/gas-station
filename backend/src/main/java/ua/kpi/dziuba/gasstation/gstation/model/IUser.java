package ua.kpi.dziuba.gasstation.gstation.model;

import java.util.UUID;

public interface IUser {
    Integer getId();

    UUID getGuid();

    String getName();

    String getSurname();

    String getLogin();

    String getPasswordHash();

    String getEmail();
}