package com.lili.feed.service.currentuser;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lili.feed.domain.CurrentUser;
import com.lili.feed.domain.Role;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = Logger.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOGGER.debug(String.format("Checking if user=%s has access to user=%d", currentUser.toString(), userId));
        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}
