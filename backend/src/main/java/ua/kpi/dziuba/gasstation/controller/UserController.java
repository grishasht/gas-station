package ua.kpi.dziuba.gasstation.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.dziuba.gasstation.exception.InvalidUserDataException;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.model.impl.User;
import ua.kpi.dziuba.gasstation.service.IUserService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private static final String RESPONSE_FIELD_GUID = "guid";

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/guest/sign-up")
    public String signUp(@RequestBody @Valid User requestUser) {

        if (!userService.validateUserData(requestUser)) {
            final String msg = "Invalid user credential data!";

            LOGGER.error(msg);
            throw new InvalidUserDataException(msg);
        }

        final String requestUserLogin = requestUser.getLogin();

        LOGGER.info("User {} credential data is successfully validated", requestUserLogin);

        final IUser newUser = userService.createUser(requestUser);

        LOGGER.info("User {} info successfully created!", newUser.getLogin());

        final JSONObject responseJson = new JSONObject();

        responseJson.put(RESPONSE_FIELD_GUID, newUser.getGuid().toString());

        return responseJson.toString();
    }

    @GetMapping("/{userGuid}/personal")
    public IUser getAllUserInfo(@PathVariable UUID userGuid) {

        final IUser user = userService.getUserInfo(userGuid);

        LOGGER.info("User {} info successfully retrieved from the database", user.getLogin());

        return user;
    }

    @PutMapping("/{userGuid}/personal")
    public void updateUserInfo(@RequestBody @Valid User newUserInfo, @PathVariable UUID userGuid) {

        userService.updateUserByGuid(newUserInfo, userGuid);

        LOGGER.info("User {} info successfully updated in the database", newUserInfo.getLogin());
    }



    @DeleteMapping("/{userGuid}/personal")
    public void removeUser(@PathVariable UUID userGuid) {

        final IUser removedUser = userService.removeUserByGuid(userGuid);

        LOGGER.info("User {} info successfully removed from the database", removedUser.getLogin());

    }

}
