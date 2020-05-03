package ua.kpi.dziuba.gasstation.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.kpi.dziuba.gasstation.service.IUserService;
import ua.kpi.dziuba.gasstation.service.iml.UserService;

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
}
