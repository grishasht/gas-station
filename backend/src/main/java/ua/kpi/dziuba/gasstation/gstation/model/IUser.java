package ua.kpi.dziuba.gasstation.gstation.model;

public interface IUser {
    Integer getId();

    String getName();

    String getSurname();

    String getLogin();

    String getPasswordHash();

    String getEmail();
}