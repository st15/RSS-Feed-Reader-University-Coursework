package com.lili.feed.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lili.feed.domain.CurrentUser;
import com.lili.feed.domain.FeedForm;
import com.lili.feed.service.feed.FeedService;
import com.lili.feed.service.user.UserService;

@Controller
public class FeedController {
	
    private static final Logger LOGGER = Logger.getLogger(FeedController.class);
    private final FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        LOGGER.debug("Getting add feed form");
        return new ModelAndView("add_feed", "feed", new FeedForm());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("feed") FeedForm form, 
    		Authentication authentication) {
    	
       
        try {

            CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
            LOGGER.debug("currentUser: " + currentUser);
            LOGGER.debug("currentUser: " + currentUser.getUser());
            LOGGER.debug("form url: " + form.getUrl());
            feedService.addFeed(form, currentUser.getUser());
        } catch (Exception e) { 
            LOGGER.warn("Exception occurred when trying to save the feed", e);
            return "add_feed";
        }
        return "redirect:/";
    }
}
