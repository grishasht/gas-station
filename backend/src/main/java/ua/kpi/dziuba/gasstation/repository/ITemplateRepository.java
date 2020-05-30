package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.ITemplate;
import ua.kpi.dziuba.gasstation.model.impl.Template;

import java.util.List;
import java.util.UUID;

/**
 * Репозиторій, який відповідає за маніпуляцію таблицею і сутністю колонок
 * з пальним в базі даних - CRUD - операції.
 */
@Component
public interface ITemplateRepository extends CrudRepository<Template, Integer> {

    /**
     * Метод який витягує з бази даних шаблони з вибору пального по параметру
     * унікального ідентифікатора користувача.
     *
     * @param userGuid - унікальний ідентифікатор користувача по якому
     *                 будуть витягуватися дані
     * @return список шаблонів вибору пального, тобто історії заправок
     * по вказаним параметрам
     */
    List<ITemplate> findAllByUserGuid(UUID userGuid);

    /**
     * Метод який витягує з бази даних шаблони з вибору пального по параметру
     * унікального ідентифікатора користувача.
     *
     * @param name - ім'я шаблону, по якому будуть витягуватися дані
     * @return список шаблонів вибору пального, тобто історії заправок
     * по вказаним параметрам
     */
    ITemplate findByName(String name);

    /**
     * Метод який витягує з бази даних шаблони з вибору пального по параметрах
     * унікального ідентифікатора користувача та ідентифікатора шаблону.
     *
     * @param userGuid - унікальний ідентифікатор користувача по якому
     *                 будуть витягуватися дані
     * @param id - унікальний ідентифікатор шаблону, по якому будуть
     *           витягуватися дані
     * @return список шаблонів вибору пального, тобто історії заправок
     * по вказаним параметрам
     */
    void removeByIdAndUserGuid(Integer id, UUID userGuid);

    /**
     * Метод який витягує з бази даних шаблони з вибору пального по параметрах
     * унікального ідентифікатора користувача та ідентифікатора шаблону.
     *
     * @param userGuid - унікальний ідентифікатор користувача по якому
     *                 будуть витягуватися дані
     * @param name - ім'я шаблону, по якому будуть витягуватися дані
     * @return список шаблонів вибору пального, тобто історії заправок
     * по вказаним параметрам
     */
    List<ITemplate> findByUserGuidAndName(UUID userGuid, String name);
}
