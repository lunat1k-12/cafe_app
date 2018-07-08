package com.cafetery.service;

import com.cafetery.domain.User;

public interface IUserService {

    String generateClientId();

    User registerWaitress(User user);
}
