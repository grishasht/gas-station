package ua.kpi.dziuba.gasstation.gstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dziuba.gasstation.gstation.model.impl.User;
import ua.kpi.dziuba.gasstation.gstation.model.impl.builder.UserBuilder;
import ua.kpi.dziuba.gasstation.gstation.repository.IUserRepository;

import java.util.UUID;

@RestController
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(IUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/guest/sign-up")
    public void signUp(@RequestBody User requestUser) {

        final User newUser = UserBuilder.newBuilder()
                .setName(requestUser.getName())
                .setSurname(requestUser.getSurname())
                .setEmail(requestUser.getEmail())
                .setGuid(UUID.randomUUID())
                .setLogin(requestUser.getLogin())
                .setPasswordHash(bCryptPasswordEncoder.encode(requestUser.getPasswordHash()))
                .build();

        userRepository.save(newUser);
    }

}
