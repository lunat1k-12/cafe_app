package com.cafetery.service.auth;

import com.cafetery.constants.AppConstants;
import com.cafetery.dao.UserRepository;
import com.cafetery.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CafeUserDetailServiceTest {

    @Mock
    private UserRepository userRepo;

    @Mock
    private BCryptPasswordEncoder encoder;

    @InjectMocks
    private CafeUserDetailService service;

    @Test
    public void loadUserByUsername_hp() {

        String username = "username";

        when(userRepo.findById(username)).thenReturn(Optional.of(new User()));
        when(encoder.encode(AppConstants.DEFAULT_PASS)).thenReturn("PASS");

        UserDetails res = service.loadUserByUsername(username);

        assertEquals("PASS",res.getPassword());
        verify(userRepo).findById(username);
        verify(encoder).encode(AppConstants.DEFAULT_PASS);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_userNotFound() {

        when(userRepo.findById(anyString())).thenReturn(Optional.empty());
        service.loadUserByUsername("username");
    }
}
