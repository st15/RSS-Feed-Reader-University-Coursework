package com.lili.feed.service.feed;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lili.feed.domain.FeedEntity;
import com.lili.feed.domain.FeedForm;
import com.lili.feed.domain.User;
import com.lili.feed.repository.FeedRepository;
import com.lili.feed.repository.UserRepository;

@Service
public class FeedServiceImpl implements FeedService {

    private static final Logger LOGGER = Logger.getLogger(FeedServiceImpl.class);
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Autowired
    public FeedServiceImpl(FeedRepository feedRepository, UserRepository userRepository) {
        this.feedRepository = feedRepository;
        this.userRepository = userRepository;
    }

    
	@Override
	public Boolean addFeed(FeedForm form, User user) {
		// after the feed is added successfully, updates the user
		if (user.getFeed().add(feedRepository.save(new FeedEntity(user, form.getUrl()))))
		{
			// saves if the feed has not been added before
			userRepository.save(user);
			return true;
		}
		
		return false;
	}

}
