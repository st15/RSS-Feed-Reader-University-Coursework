package com.lili.feed.service.currentuser;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lili.feed.domain.CurrentUser;
import com.lili.feed.domain.User;
import com.lili.feed.service.user.UserService;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(CurrentUserDetailsService.class);
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        LOGGER.debug(String.format("Authenticating user with email=%s", email.replaceFirst("@.*", "@***")));
        User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(user);
    }

}
