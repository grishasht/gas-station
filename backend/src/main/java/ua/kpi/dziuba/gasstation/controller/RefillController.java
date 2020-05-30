package ua.kpi.dziuba.gasstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.dziuba.gasstation.model.IRefill;
import ua.kpi.dziuba.gasstation.model.impl.Refill;
import ua.kpi.dziuba.gasstation.service.IPumpService;
import ua.kpi.dziuba.gasstation.service.IRefillService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/{userGuid}")
public class RefillController {
    public static final Logger LOGGER = LoggerFactory.getLogger(RefillController.class);

    private final IRefillService refillService;

    @Autowired
    public RefillController(IRefillService refillService) {
        this.refillService = refillService;
    }

    /**
     * Метод, що повертає всю історію заправок користувача із бази даних по вказаному в адресному
     * рядку шляху (в дужках нижче) та ННТР - методу GET.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link IRefillService}, обробляє його. Даний сервіс повертає отримані та оброблені
     * дані історії заправок із бази даних.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/refills
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     *
     * @return джейсон у вигляді масиву сутностей попередніх заправок користувача.
     */
    @GetMapping("/refills")
    public List<IRefill> getAllUserRefillHistory(@PathVariable @Valid UUID userGuid) {

        final List<IRefill> allRefillsByUserGuid = refillService.getAllRefills(userGuid);

        LOGGER.info("All user {} refill history s retrieved!", userGuid);

        return allRefillsByUserGuid;
    }

    /**
     * Метод, що відправляє виконану заправку свого транспорту в базу даних в таблицю історії заправок
     * по вказаному в адресному рядку шляху (в дужках нижче) та ННТР - методу POST.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link IRefillService}, обробляє його, записує отримані дані у таблицю історії заправок в
     * базі даних у відповідності до користувача.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/refill
     *
     * Дані виконаної заправки транспортного засобу відправляються в тілі POST-методу у форматі JSON.
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     */
    @PostMapping("/refill")
    public void createRefillForUser(@PathVariable @Valid UUID userGuid, @RequestBody @Valid Refill refill) {

        final IRefill newRefill = refillService.createNewRefill(refill);

        LOGGER.info("New refill '{}' created for user {}", newRefill.getId(), userGuid);

    }

}
