package ua.kpi.dziuba.gasstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.dziuba.gasstation.model.ITemplate;
import ua.kpi.dziuba.gasstation.service.ITemplateService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/{userGuid}")
public class TemplateController {
    public static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    private final ITemplateService templateService;

    @Autowired
    public TemplateController(ITemplateService templateService) {
        this.templateService = templateService;
    }

    /**
     * Метод, що повертає всі шаблони введених даних заправки користувача із бази даних
     * по вказаному в адресному рядку шляху (в дужках нижче) та ННТР - методу GET.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link ITemplateService}, обробляє його. Даний сервіс повертає отримані та оброблені
     * дані шаблонів заповнення даних заправки із бази даних.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/templates
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     *
     * @return джейсон у вигляді масиву сутностей шаблонів заповнення даних заправки користувача.
     */
    @GetMapping("/templates")
    public List<ITemplate> getAllUserTemplates(@PathVariable @Valid UUID userGuid) {

        final List<ITemplate> templateList = templateService.getAllTemplatesByUserGuid(userGuid);

        LOGGER.info("All templates retrieved for user {} successfully!", userGuid);

        return templateList;

    }

    /**
     * Метод, що повертає один шаблон введених даних заправки користувача із бази даних
     * по вказаному в адресному рядку шляху (в дужках нижче) та ННТР - методу GET.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link ITemplateService}, обробляє його. Даний сервіс повертає отримані та оброблені
     * дані шаблону заповнення даних заправки із бази даних.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/template?templateName=оптимальне%20заправлення
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     *
     * @return респонс у форматі JSON у вигляді масиву сутностей шаблонів заповнення даних
     * заправки користувача.
     */
    @GetMapping("/template")
    public List<ITemplate> getAllUserTemplatesByName(@PathVariable @Valid UUID userGuid, @RequestParam String templateName) {

        final List<ITemplate> templateList = templateService.getAllTemplatesByName(userGuid, templateName);

        LOGGER.info("Template by name {} retrieved for user {} successfully!", templateName, userGuid);

        return templateList;

    }

    /**
     * Метод, що відправляє новостворений шаблон введення даних заправки в базу даних в таблицю
     * шаблонів по вказаному в адресному рядку шляху (в дужках нижче) та ННТР - методу POST.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link ITemplateService}, обробляє його, записує отримані дані у таблицю шаблонів введення даних
     * заправки в базі даних у відповідності до користувача.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/template
     *
     * Дані шаблон введення даних заправки відправляються в тілі POST-методу у форматі JSON.
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     */
    @PostMapping("/template")
    public void createTemplate(@PathVariable @Valid UUID userGuid, @RequestBody ITemplate template) {

        templateService.createTemplate(template);

        LOGGER.info("New template '{}' successfully created!", template.getName());
    }

    /**
     * Метод, що оновлює дані раніше створеного шаблону введення даних заправки в базі даних в таблиці
     * шаблонів по вказаному в адресному рядку шляху (в дужках нижче) та ННТР - методу PUT.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link ITemplateService}, обробляє його, оновлює отримані дані у таблиці шаблонів введення даних
     * заправки в базі даних у відповідності до користувача.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/template
     *
     * Дані шаблон введення даних заправки відправляються в тілі PUT-методу у форматі JSON.
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     * @param newTemplateInfo - обов'язковий параметр. Тіло нових даних шаблону введення даних заправки
     *                        користувача. Даний параметр приходить у формалі JSON та парситься
     *                        до моделі {@link ITemplate}
     */
    @PutMapping("/template")
    public void updateTemplate(@PathVariable @Valid UUID userGuid, @RequestBody ITemplate newTemplateInfo) {

        templateService.updateTemplate(newTemplateInfo);

        LOGGER.info("Template '{}' data successfully updated!", newTemplateInfo.getName());

    }

    /**
     * Метод, що видаляє шаблон введення даних заправки із бази даних із таблиці шаблонів
     * по вказаному в адресному рядку шляху (в дужках нижче) та ННТР - методу DELETE.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс {@link ITemplateService},
     * обробляє його, та по ідентифікатору шаблона видаляє його із таблиці шаблонів введення даних
     * заправки в базі даних у відповідності до користувача.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/template?templateId=5
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     * @param templateId обов'язковий параметр. Унікальний ідентифікатор шаблону, по якому
     *                   буде виконуватися його видалення із бази даних.
     */
    @DeleteMapping("/templates/{templateId}")
    public void removeTemplateById(@PathVariable @Valid UUID userGuid, @PathVariable Integer templateId) {

        templateService.removeTemplateById(templateId, userGuid);

        LOGGER.info("Template with id {} successfully removed from the database!", templateId);
    }
}
