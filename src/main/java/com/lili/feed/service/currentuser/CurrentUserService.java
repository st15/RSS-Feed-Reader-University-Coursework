package com.lili.feed.service.currentuser;

import com.lili.feed.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
