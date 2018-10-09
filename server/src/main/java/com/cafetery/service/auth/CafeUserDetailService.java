package com.cafetery.service.auth;

import com.cafetery.constants.AppConstants;
import com.cafetery.dao.UserRepository;
import com.cafetery.domain.AppUser;
import com.cafetery.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class CafeUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> dbUser = userRepo.findById(username);

        if(!dbUser.isPresent())
        {
           throw new UsernameNotFoundException("User not found...");
        }

        User user = dbUser.get();
        user.setPassword(user.getPassword() == null ? encoder.encode(AppConstants.DEFAULT_PASS)
                : encoder.encode(user.getPassword()));
        return new AppUser(user);
    }
}
