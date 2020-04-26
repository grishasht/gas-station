package ua.kpi.dziuba.gasstation.gstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dziuba.gasstation.gstation.model.impl.Fuel;

import java.util.List;

@RestController
public class FuelController {
    public static final Logger LOGGER = LoggerFactory.getLogger(FuelController.class);

    @GetMapping("/fuel")
    public List<Fuel> all() {

        return List.of(
                new Fuel("type1", "name1"),
                new Fuel("type2", "name2")
        );
    }

}
