package ua.kpi.dziuba.gasstation.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ua.kpi.dziuba.gasstation.exception.GasStationException;
import ua.kpi.dziuba.gasstation.exception.InvalidUserDataException;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.model.impl.User;
import ua.kpi.dziuba.gasstation.model.impl.builder.UserBuilder;
import ua.kpi.dziuba.gasstation.repository.IUserRepository;
import ua.kpi.dziuba.gasstation.service.IUserService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final IUserService userService;

    @Autowired
    public UserController(IUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, IUserService userService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    @PostMapping("/guest/sign-up")
    public JSONObject signUp(@RequestBody @Valid User requestUser) {

        final UUID newUserGuid = UUID.randomUUID();

        final String requestUserEmail = requestUser.getEmail();
        final String requestUserLogin = requestUser.getLogin();
        final String requestUserPassword = requestUser.getPassword();

        if (!userService.validateUserData(requestUser)) {
            final String msg = "Invalid user credential data!";

            LOGGER.error(msg);
            throw new InvalidUserDataException(msg);
        }

        LOGGER.info("User {} credential data is successfully validated", requestUserLogin);

        final User newUser = UserBuilder.newBuilder()
                .setName(requestUser.getName())
                .setSurname(requestUser.getSurname())
                .setEmail(requestUserEmail)
                .setGuid(newUserGuid)
                .setLogin(requestUserLogin)
                .setPassword(bCryptPasswordEncoder.encode(requestUserPassword))
                .build();

        userRepository.save(newUser);

        LOGGER.info("User {} info successfully created!", newUser.getLogin());

        return new JSONObject().put("guid", newUserGuid.toString());
    }

    @PutMapping("/{userGuid}/personal")
    public void updateUserInfo(@RequestBody @Valid User newUserInfo, @PathVariable UUID userGuid) {
        final Integer userIdByGuid = userRepository.getUserByGuid(userGuid).getId();

        final User newUser = UserBuilder.newBuilder()
                .setId(userIdByGuid)
                .setGuid(userGuid)
                .setName(newUserInfo.getName())
                .setSurname(newUserInfo.getSurname())
                .setLogin(newUserInfo.getLogin())
                .setPassword(bCryptPasswordEncoder.encode(newUserInfo.getPassword()))
                .setEmail(newUserInfo.getEmail())
                .build();

        userRepository.save(newUser);

        LOGGER.info("User {} info successfully updated in the database", newUserInfo.getLogin());
    }

    @DeleteMapping("/{userGuid}/personal")
    public void removeUser(@PathVariable UUID userGuid) {

        final IUser userByGuid = userRepository.getUserByGuid(userGuid);

        userRepository.removeUserByGuid(userGuid);

        LOGGER.info("User {} info successfully removed from the database", userByGuid.getLogin());

    }

}
