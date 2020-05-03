package ua.kpi.dziuba.gasstation.service.iml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kpi.dziuba.gasstation.controller.UserController;
import ua.kpi.dziuba.gasstation.exception.InvalidUserDataException;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.service.IUserService;

import java.util.regex.Pattern;

public class UserService implements IUserService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final static String PATTERN_EMAIL = "\\S{4,25}@\\w{1,10}.\\w{1,4}";
    private final static String PATTERN_LOGIN = "\\S{4,20}";
    private final static String PATTERN_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$";

    private static final String ERROR_MESSAGE_INVALID_EMAIL = "Entered email is invalid!\n";
    private static final String ERROR_MESSAGE_INVALID_LOGIN = "Entered login is invalid! Must consist of non-whitespace characters and at least 4 chars.\n";
    private static final String ERROR_MESSAGE_INVALID_PASSWORD = "Entered password is invalid! Must contain at least 1 uppercase, 1 lowercase and 1 digit chars. Minimum length 6 chars.";

    @Override
    public Boolean validateEmail(String email) {
        return Pattern.matches(PATTERN_EMAIL, email);
    }

    @Override
    public Boolean validateLogin(String login) {
        return Pattern.matches(PATTERN_LOGIN, login);
    }

    @Override
    public Boolean validatePassword(String password) {
        return Pattern.matches(PATTERN_PASSWORD, password);
    }

    @Override
    public Boolean validateUserData(IUser user) {

        final StringBuilder errorMessage = new StringBuilder();

        final String userEmail = user.getEmail();
        final boolean isEmailValid = validateEmail(userEmail);

        if (!isEmailValid) {
            LOGGER.error("Invalid user input email: {}", userEmail);

            errorMessage.append(ERROR_MESSAGE_INVALID_EMAIL);
        }

        final String userLogin = user.getLogin();
        final Boolean isLoginValid = validateLogin(userLogin);

        if (!isLoginValid){
            LOGGER.error("Invalid user input login: {}", userLogin);

            errorMessage.append(ERROR_MESSAGE_INVALID_LOGIN);
        }

        final String userPassword = user.getPassword();
        final Boolean isPasswordValid = validatePassword(userPassword);

        if (!isPasswordValid) {
            LOGGER.error("Invalid user input password: {}", userPassword);

            errorMessage.append(ERROR_MESSAGE_INVALID_PASSWORD);
        }

        if (errorMessage.length() == 1) {
            throw new InvalidUserDataException(errorMessage.toString().replace("\n", ""));
        } else if (errorMessage.length() > 1) {
            throw new InvalidUserDataException(errorMessage.toString());
        }

        return true;
    }
}
