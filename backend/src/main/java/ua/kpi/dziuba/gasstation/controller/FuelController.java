package ua.kpi.dziuba.gasstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dziuba.gasstation.model.IFuel;
import ua.kpi.dziuba.gasstation.service.IFuelService;

import java.util.List;

@RestController
public class FuelController {
    public static final Logger LOGGER = LoggerFactory.getLogger(FuelController.class);

    private final IFuelService fuelService;

    @Autowired
    public FuelController(IFuelService fuelService) {
        this.fuelService = fuelService;
    }

    /**
     * Метод, що повертає все пальне із бази даних по вказаному в адресному рядку шляху
     * (в дужках нижче) та ННТР - методу GET.
     *
     * Даний контроллер отримує запит від клієнта та, викликаючи сервіс
     * {@link IFuelService}, обробляє його. Даний сервіс повертає отримані та оброблені
     * дані із бази даних.
     *
     * Приклади використання контроллеру.
     *      https://gas-station/"some guid"/fuels
     *      , або
     *      https://gas-station/guest/fuels
     *      , або будь-яке інше посилання. Головне, щою воно закінчувалося на /fuels
     *
     * @return джейсон у вигляді масиву сутностей пального.
     */
    @GetMapping("**/fuels")
    public List<IFuel> getAllFuelList() {

        final List<IFuel> allFuelList = fuelService.getAllFuels();

        LOGGER.info("All fuels retrieved from the database");

        return allFuelList;
    }

}
