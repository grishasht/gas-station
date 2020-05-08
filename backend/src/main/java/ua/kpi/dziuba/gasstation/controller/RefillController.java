package ua.kpi.dziuba.gasstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.dziuba.gasstation.model.IRefill;
import ua.kpi.dziuba.gasstation.model.impl.Refill;
import ua.kpi.dziuba.gasstation.service.IRefillService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("{userGuid/}")
public class RefillController {
    public static final Logger LOGGER = LoggerFactory.getLogger(RefillController.class);

    private final IRefillService refillService;

    @Autowired
    public RefillController(IRefillService refillService) {
        this.refillService = refillService;
    }

    @GetMapping("refills/")
    public List<IRefill> getAllUserRefillHistory(@PathVariable @Valid UUID userGuid) {

        final List<IRefill> allRefillsByUserGuid = refillService.getAllRefills(userGuid);

        LOGGER.info("All user {} refill history s retrieved!", userGuid);

        return allRefillsByUserGuid;
    }

    @PostMapping("refill/")
    public void createRefillForUser(@PathVariable @Valid UUID userGuid, @RequestBody @Valid Refill refill) {

        final IRefill newRefill = refillService.createNewRefill(refill);

        LOGGER.info("New refill '{}' created for user {}", newRefill.getId(), userGuid);

    }

}
