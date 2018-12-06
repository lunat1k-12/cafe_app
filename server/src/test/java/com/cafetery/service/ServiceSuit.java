package com.cafetery.service;

import com.cafetery.service.auth.CafeUserDetailServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MenuServiceTest.class,
        OrderServiceTest.class,
        UserServiceTest.class,
        ClientNotifyTest.class,
        TableServiceTest.class,
        CafeUserDetailServiceTest.class
})
public class ServiceSuit {
}
