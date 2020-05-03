package ua.kpi.dziuba.gasstation.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.repository.IUserRepository;

import java.util.Collections;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        final IUser user = userRepository.getUserByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException(login);
        }

        return new User(user.getLogin(), user.getPassword(), Collections.emptyList());
    }
}