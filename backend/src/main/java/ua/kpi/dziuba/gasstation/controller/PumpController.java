package ua.kpi.dziuba.gasstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dziuba.gasstation.model.IPump;
import ua.kpi.dziuba.gasstation.service.IPumpService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class PumpController {

    public static final Logger LOGGER = LoggerFactory.getLogger(PumpController.class);

    private final IPumpService pumpService;

    @Autowired
    public PumpController(IPumpService pumpService) {
        this.pumpService = pumpService;
    }


    /**
     * Метод, що повертає всі колонки із пальним із бази даних по вказаному в адресному рядку шляху
     * (в дужках нижче), ННТР - методу GET та вказаних параметрах-фільтрах.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link IPumpService}, обробляє його. Даний сервіс повертає отримані та оброблені
     * дані колонок пального із бази даних.
     *
     * Приклади використання контроллеру.
     *      Можна використовувати як тільки один із параметрів у адресному рядку, на приклад:
     *      https://gas-station/"some guid"/pumps?city=Kyiv
     *              або
     *      https://gas-station/"some guid"/pumps?station=Boryspil%20AZS
     *
     *      так і одразу оба параметри, на приклад:
     *      https://gas-station/"some guid"/pumps?city=Kyiv&station=Boryspil%20AZS
     *
     *      так і без параметрів, на приклад:
     *      https://gas-station/"some guid"/pumps
     *             - у такому випадку із бази даних витягнуться всі колонки із пальним, та
     *              передадуться клієнту через даний контроллер.
     *
     * @param userGuid - параметр шляху адресного рядку. унікальний ідентифікатор користувача,
     *                  завдяки якому здійснюється доступ до ресурсів сервера. Обов'язковий
     *                 параметр.
     * @param city - необов'язковий параметр. Фільтр, по якому дістаються колонки із пальним із
     *             бази даних.
     * @param station - - необов'язковий параметр. Фільтр, по якому дістаються колонки із пальним із
     *             бази даних.
     * @return джейсон у вигляді масиву сутностей колонок із пальним.
     */
    @GetMapping("{userGuid}/pumps")
    public List<IPump> getAllPumpsByCityAndStation(@PathVariable @Valid UUID userGuid,
                                                   @RequestParam(required = false) String city,
                                                   @RequestParam(required = false) String station) {

        if (city == null && station == null) {
            final List<IPump> allPumps = pumpService.getAllPumps();

            LOGGER.info("All pumps are successfully retrieved!");

            return allPumps;
        } else if (city == null) {
            final List<IPump> pumpsByStation = pumpService.getPumpsByStation(station);

            LOGGER.info("All pumps are retrieved by station {}", station);

            return pumpsByStation;
        } else if (station == null) {
            final List<IPump> pumpsByCity = pumpService.getPumpsByCity(city);

            LOGGER.info("All pumps are retrieved by city {}", city);

            return pumpsByCity;
        }

        final List<IPump> pumpsByCityAndStation = pumpService.getPumpsByCityAndStation(city, station);

        LOGGER.info("All pumps are retrieved by city={} and station={}", city, station);

        return pumpsByCityAndStation;
    }
}
