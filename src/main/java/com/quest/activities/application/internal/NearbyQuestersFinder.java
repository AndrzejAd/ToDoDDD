package com.quest.activities.application.internal;

import com.ddd.common.annotations.DomainService;
import com.quest.activities.domain.location.NearbyQuesters;
import com.quest.activities.domain.user.User;


@DomainService
public interface NearbyQuestersFinder {
    NearbyQuesters getNearbyUsers(User user);
}
