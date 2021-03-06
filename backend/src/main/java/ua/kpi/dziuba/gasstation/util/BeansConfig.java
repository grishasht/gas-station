package ua.kpi.dziuba.gasstation.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.kpi.dziuba.gasstation.service.*;
import ua.kpi.dziuba.gasstation.service.impl.*;

@Configuration
public class BeansConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserService userService() {
        return new UserService();
    }

    @Bean
    public IPumpService pumpService() {
        return new PumpService();
    }

    @Bean
    public ITemplateService templateService() {
        return new TemplateService();
    }

    @Bean
    public IFuelService fuelService() {
        return new FuelService();
    }

    @Bean
    public IRefillService refillService() {
        return new RefillService();
    }
}
