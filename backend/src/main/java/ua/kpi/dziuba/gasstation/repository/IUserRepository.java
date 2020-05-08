package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.model.impl.User;

import java.util.UUID;

@Component
public interface IUserRepository extends CrudRepository<User, Integer> {

    IUser getUserByLogin(String login);

    IUser getUserByGuid(UUID guid);

    @Query("select new User(u.name, u.surname, u.login, u.email, u.city) from User u where u.guid = :guid")
    IUser getUserByGuidNoPassword(@Param("guid") UUID guid);

    void removeUserByGuid(UUID guid);
}
