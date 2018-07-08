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
        return generateClientId(CafeRoles.ANONIMOUS.toString()).getId();
    }

    @Override
    public User registerWaitress(User user) {

        return generateClientId(CafeRoles.WAITRESS.toString());
    }

    private User generateClientId(String role) {
        String id;
        do {
            id = UUID.randomUUID().toString();
        } while (userRepo.findById(id).isPresent());

        User user = new User();
        user.setId(id);
        user.setRole(role);

        return userRepo.save(user);
    }
}
