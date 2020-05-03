package ua.kpi.dziuba.gasstation.service;

import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IUser;

@Component
public interface IUserService {

    Boolean validateEmail(String email);

    Boolean validateLogin(String login);

    Boolean validatePassword(String password);

    Boolean validateUserData(IUser user);
}
