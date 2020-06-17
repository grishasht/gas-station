package ua.kpi.dziuba.gasstation.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.dziuba.gasstation.exception.InvalidUserDataException;
import ua.kpi.dziuba.gasstation.model.ITemplate;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.model.impl.User;
import ua.kpi.dziuba.gasstation.service.ITemplateService;
import ua.kpi.dziuba.gasstation.service.IUserService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private static final String RESPONSE_FIELD_GUID = "guid";

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Метод, що реєструє нового користувача в системі та створює його в базі даних в таблиці
     * користувачів по вказаному в адресному рядку шляху (в дужках нижче) та ННТР - методу POST.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link IUserService}, обробляє його, записує отримані дані у таблицю користувачів
     * системою в базі даних.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/guest/sign-up
     *
     * Дані шаблон введення даних заправки відправляються в тілі POST-методу у форматі JSON.
     *
     * @param requestUser - обов'язковий параментр. Тіло нового користувача, надіслане у форматі
     *                      JSON та спарсене до моделі {@link IUser}.
     * @return респонс у форматі JSON із полем userGuid, яке містить унікальний ідентифікатор
     * доступу до системи нового користувача у випадку успішного проходження валідації даних та
     * успішної реєстрації.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/guest/sign-up")
    public String signUp(@RequestBody @Valid User requestUser) {

        if (!userService.validateUserData(requestUser)) {
            final String msg = "Invalid user credential data!";

            LOGGER.error(msg);
            throw new InvalidUserDataException(msg);
        }

        final String requestUserLogin = requestUser.getLogin();

        LOGGER.info("User {} credential data is successfully validated", requestUserLogin);

        final IUser newUser = userService.createUser(requestUser);

        LOGGER.info("User {} info successfully created!", newUser.getLogin());

        final JSONObject responseJson = getGuidJson(newUser);

        return responseJson.toString();
    }

    /**
     * Метод, що повертає респонс у форматі JSON, який містить поле userGuid із унікальним
     * ідентифікатором доступу до ресурсів серверу після входу в систему по вказаному в
     * адресному рядку шляху (в дужках нижче) та ННТР - методу GET.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс {@link IUserService},
     * обробляє його, та повертає дані користувача із бази даних із таблиці користувачів.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/guest/login
     *
     * @return респонс у форматі JSON із полем userGuid, яке містить унікальний ідентифікатор
     * доступу до системи нового користувача у випадку успішного проходження валідації даних та
     * успішної реєстрації.
     */
    @GetMapping("/guest/login")
    public String userLogin(@RequestBody User user){

        final String userLogin = user.getLogin();
        final IUser userByLogin = userService.getUserByLogin(userLogin);

        LOGGER.info("User {} guild retrieved!", userLogin);

        return getGuidJson(userByLogin).toString();
    }

    /**
     * Метод, що повертає інформацію користувача із бази даних по вказаному в адресному
     * рядку шляху (в дужках нижче) та ННТР - методу GET.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link IUserService}, обробляє його. Даний сервіс повертає отримані та оброблені
     * дані користувача із бази даних.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/personal
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     *
     * @return респонс у форматі JSON який містить дані користувача.
     */
    @GetMapping("/{userGuid}/personal")
    public IUser getAllUserInfo(@PathVariable UUID userGuid) {

        final IUser user = userService.getUserInfo(userGuid);

        LOGGER.info("User {} info successfully retrieved from the database", user.getLogin());

        return user;
    }

    /**
     * Метод, що оновлює дані раніше створеного користувача в базі даних в таблиці користувачів
     * по вказаному в адресному рядку шляху (в дужках нижче) та ННТР - методу PUT.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link IUserService}, обробляє його, оновлює отримані дані у таблиці користувачів
     * у базі даних у відповідності до користувача.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/personal
     *
     * Дані шаблон введення даних заправки відправляються в тілі PUT-методу у форматі JSON.
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                   завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                   параметр.
     * @param newUserInfo - обов'язковий параметр. Тіло нових даних користувача. Даний параметр
     *                      приходить у формалі JSON та приводиться до моделі {@link IUser}
     */
    @PutMapping("/{userGuid}/personal")
    public void updateUserInfo(@PathVariable UUID userGuid, @RequestBody @Valid User newUserInfo) {

        userService.updateUserByGuid(newUserInfo, userGuid);

        LOGGER.info("User {} info successfully updated in the database", newUserInfo.getLogin());
    }

    /**
     * Метод, що видаляє користувача із бази даних із таблиці користувачів по вказаному в адресному
     * рядку шляху (в дужках нижче), параметра userGuid та ННТР - методу DELETE.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс {@link IUserService},
     * обробляє його, та по унікальному ідентифікатору користувача видаляє його із таблиці
     * користувачів бази даних.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/personal
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     */
    @DeleteMapping("/{userGuid}/personal")
    public void removeUser(@PathVariable UUID userGuid) {

        final IUser removedUser = userService.removeUserByGuid(userGuid);

        LOGGER.info("User {} info successfully removed from the database", removedUser.getLogin());

    }

    private JSONObject getGuidJson(IUser user) {
        final JSONObject responseJson = new JSONObject();

        responseJson.put(RESPONSE_FIELD_GUID, user.getGuid().toString());
        return responseJson;
    }
}
