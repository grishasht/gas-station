package ua.kpi.dziuba.gasstation.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.kpi.dziuba.gasstation.exception.InvalidUserDataException;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.model.impl.User;
import ua.kpi.dziuba.gasstation.model.impl.builder.UserBuilder;
import ua.kpi.dziuba.gasstation.repository.IUserRepository;
import ua.kpi.dziuba.gasstation.service.IUserService;

import java.util.UUID;
import java.util.regex.Pattern;

public class UserService implements IUserService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final static String PATTERN_EMAIL = "\\S{4,25}@\\w{1,10}.\\w{1,4}";
    private final static String PATTERN_LOGIN = "\\S{4,20}";
    private final static String PATTERN_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$";

    private static final String ERROR_MESSAGE_INVALID_EMAIL = "Entered email is invalid!\n";
    private static final String ERROR_MESSAGE_INVALID_LOGIN = "Entered login is invalid! " +
            "Must consist of non-whitespace characters and at least 4 chars.\n";
    private static final String ERROR_MESSAGE_INVALID_PASSWORD = "Entered password is invalid! " +
            "Must contain at least 1 uppercase, 1 lowercase and 1 digit chars. Minimum length 6 chars.\n";

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Boolean validateEmail(String email) {
        return Pattern.matches(PATTERN_EMAIL, email);
    }

    private Boolean validateLogin(String login) {
        return Pattern.matches(PATTERN_LOGIN, login);
    }

    private Boolean validatePassword(String password) {
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

    @Override
    public IUser createUser(IUser user) {

        final UUID newUserGuid = UUID.randomUUID();

        final User newUser = UserBuilder.newBuilder()
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setGuid(newUserGuid)
                .setLogin(user.getLogin())
                .setPassword(bCryptPasswordEncoder.encode(user.getPassword()))
                .setCity(user.getCity())
                .build();

        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public IUser getUserInfo(UUID guid) {

        return userRepository.getUserByGuidNoPassword(guid);
    }

    @Override
    public IUser getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public IUser updateUserByGuid(IUser newUserInfo, UUID userGuid) {
        final Integer userIdByGuid = userRepository.getUserByGuid(userGuid).getId();

        final User newUser = UserBuilder.newBuilder()
                .setId(userIdByGuid)
                .setGuid(userGuid)
                .setName(newUserInfo.getName())
                .setSurname(newUserInfo.getSurname())
                .setLogin(newUserInfo.getLogin())
                .setPassword(bCryptPasswordEncoder.encode(newUserInfo.getPassword()))
                .setEmail(newUserInfo.getEmail())
                .setCity(newUserInfo.getCity())
                .build();

        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public IUser removeUserByGuid(UUID guid) {
        final IUser userToBeRemoved = userRepository.getUserByGuid(guid);

        userRepository.removeUserByGuid(guid);

        return userToBeRemoved;
    }
}
