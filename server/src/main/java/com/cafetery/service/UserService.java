package com.cafetery.service;

import com.cafetery.constants.CafeRoles;
import com.cafetery.dao.UserRepository;
import com.cafetery.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public String generateClientId() {
        String id;
        do {
            id = UUID.randomUUID().toString();
        } while (userRepo.findById(id).isPresent());

        User user = new User();
        user.setId(id);
        user.setRole(CafeRoles.WAITRESS.toString());
        userRepo.save(user);

        return id;
    }
}
