package com.lili.feed.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lili.feed.domain.CurrentUser;

@ControllerAdvice
public class CurrentUserControllerAdvice {

    private static final Logger LOGGER = Logger.getLogger(CurrentUserControllerAdvice.class);

    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
    }


}
