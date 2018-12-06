package com.cafetery.service;

import com.cafetery.dao.UserRepository;
import com.cafetery.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepo;

    @InjectMocks
    private UserService service;

    @Test
    public void generateClientId_hp() {

        User user = new User();
        user.setId("id");
        when(userRepo.findById(anyString())).thenReturn(Optional.empty());
        when(userRepo.save(any(User.class))).thenReturn(user);

        String res = service.generateClientId();

        assertNotNull(res);
        verify(userRepo).findById(anyString());
        verify(userRepo).save(any(User.class));
    }

    @Test
    public void registerWaitress_hp() {

        User user = new User();

        when(userRepo.findById(anyString())).thenReturn(Optional.empty());
        when(userRepo.save(any(User.class))).thenReturn(user);

        User res = service.registerWaitress(user);

        assertNotNull(res);
        verify(userRepo).findById(anyString());
        verify(userRepo).save(any(User.class));
    }
}
