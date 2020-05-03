package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.model.impl.User;

import java.util.UUID;

@Component
public interface IUserRepository extends CrudRepository<User, Integer> {

    IUser getUserByLogin(String login);

    IUser getUserByGuid(UUID guid);

    void removeUserByGuid(UUID guid);
}
