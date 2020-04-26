package ua.kpi.dziuba.gasstation.gstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dziuba.gasstation.gstation.model.impl.User;

@RestController
@RequestMapping("/guest")
public class AuthController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

//    @PostMapping("/sign-in")
//    public void authorizeUser(@RequestBody User user){
//
//    }

}
