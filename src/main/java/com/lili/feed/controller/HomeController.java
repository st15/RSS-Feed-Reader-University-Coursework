package com.lili.feed.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class);

    @RequestMapping("/")
    public String getHomePage() {
        LOGGER.debug("Getting home page");
        return "home";
    }
}
