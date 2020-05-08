package ua.kpi.dziuba.gasstation.service;

import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IUser;

import java.util.List;
import java.util.UUID;

@Component
public interface IUserService {

    IUser createUser(IUser user);

    IUser getUserInfo(UUID guid);

    IUser updateUserByGuid(IUser newUserInfo, UUID userGuid);

    IUser removeUserByGuid(UUID guid);

    Boolean validateEmail(String email);

    Boolean validateLogin(String login);

    Boolean validatePassword(String password);

    Boolean validateUserData(IUser user);
}
