package com.lili.feed.service.user;

import java.util.Collection;
import java.util.Optional;

import com.lili.feed.domain.FeedEntity;
import com.lili.feed.domain.FeedForm;
import com.lili.feed.domain.User;
import com.lili.feed.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);
}
