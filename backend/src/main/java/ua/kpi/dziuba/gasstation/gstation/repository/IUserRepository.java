package ua.kpi.dziuba.gasstation.gstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.gstation.model.IUser;
import ua.kpi.dziuba.gasstation.gstation.model.impl.User;

@Component
public interface IUserRepository extends CrudRepository<User, Integer> {

    IUser findUserByLogin(String login);

}
