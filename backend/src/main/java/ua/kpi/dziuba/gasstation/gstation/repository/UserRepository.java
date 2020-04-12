package ua.kpi.dziuba.gasstation.gstation.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.dziuba.gasstation.gstation.model.impl.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    

}
