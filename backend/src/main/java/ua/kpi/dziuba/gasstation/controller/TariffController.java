package ua.kpi.dziuba.gasstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dziuba.gasstation.model.ITariff;
import ua.kpi.dziuba.gasstation.repository.ITariffRepository;
import ua.kpi.dziuba.gasstation.service.ITariffService;

import java.util.List;

@RestController
public class TariffController {

    public static final Logger LOGGER = LoggerFactory.getLogger(TariffController.class);

    private final ITariffService tariffService;

    @Autowired
    public TariffController(ITariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("**/tariffs")
    public List<ITariff> getAllTariffs(){

        final List<ITariff> tariffList = tariffService.getAllTariffs();

        LOGGER.info("All tariffs retrieved!");

        return tariffList;
    }

}
