package com.lili.feed.service.feed;

import com.lili.feed.domain.FeedEntity;
import com.lili.feed.domain.FeedForm;
import com.lili.feed.domain.User;

public interface FeedService {

	Boolean addFeed(FeedForm form, User user);
}
