package com.lili.feed.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.authority.AuthorityUtils;

import com.lili.feed.reader.FeedInfo;
import com.lili.feed.reader.FeedReader;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
    
    public Boolean getIsAdmin() {
    	return user.getRole() == Role.ADMIN;
    }
    
    public List<FeedInfo> getFeeds()
    {
    	List<FeedInfo> feedInfos = new ArrayList<>();
    	if (user != null)
    	{
        	user.getFeed().forEach((f) -> feedInfos.add(FeedReader.readFeed(f.getUrl())));
    	}
    	return feedInfos;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
