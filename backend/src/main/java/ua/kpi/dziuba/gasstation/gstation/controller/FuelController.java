package ua.kpi.dziuba.gasstation.gstation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dziuba.gasstation.gstation.model.impl.Fuel;

import java.util.List;

@RestController
public class FuelController {

    @GetMapping("/employees")
    public List<Fuel> all() {
        return null;
    }

}
