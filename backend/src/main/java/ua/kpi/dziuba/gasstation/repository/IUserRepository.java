package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.model.impl.User;

import java.util.UUID;

/**
 * Репозиторій, який відповідає за маніпуляцію таблицею і сутністю
 * користувачів в базі даних - CRUD - операції.
 */
@Component
public interface IUserRepository extends CrudRepository<User, Integer> {

    /**
     * Метод який витягує з бази даних користувача по параметру
     * логіну користувача.
     *
     * @param login - логін користувача, по якому будуть витягуватися дані
     * @return список користувачів, тобто історії заправок по вказаним
     * параметрам
     */
    IUser getUserByLogin(String login);

    /**
     * Метод який витягує з бази даних користувача по параметру
     * унікального ідентифікатора користувача.
     *
     * @param guid - унікальний ідентифікатор користувача по якому
     *                 будуть витягуватися дані
     * @return список користувачів, тобто історії заправок по вказаним
     * параметрам
     */
    IUser getUserByGuid(UUID guid);

    /**
     * Метод який витягує з бази даних користувача по параметру
     * унікального ідентифікатора користувача.
     *
     * Даний метод вилучить з бази всі поля крім паролю в цілях безпеки.
     *
     * @param guid - унікальний ідентифікатор користувача по якому
     *                 будуть витягуватися дані
     * @return список користувачів, тобто історії заправок по вказаним
     * параметрам
     */
    @Query("select new User(u.name, u.surname, u.login, u.email, u.city) from User u where u.guid = :guid")
    IUser getUserByGuidNoPassword(@Param("guid") UUID guid);

    /**
     * Метод який видаляє з бази даних користувача по параметру
     * унікального ідентифікатора користувача.
     *
     * @param guid - унікальний ідентифікатор користувача по якому
     *                 будуть витягуватися дані
     */
    void removeUserByGuid(UUID guid);
}
