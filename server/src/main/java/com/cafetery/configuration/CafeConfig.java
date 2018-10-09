package com.cafetery.configuration;

import com.cafetery.service.*;
import com.cafetery.service.auth.CafeUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class CafeConfig {

    @Bean
    public IOrderService getOrderService() {
        return new OrderService();
    }

    @Bean
    public IUserService getUserService() {
        return new UserService();
    }

    @Bean
    public IMenuService getMenuService() {
        return new MenuService();
    }

    @Bean
    public ITableService getTableService() {
        return new TableService();
    }

    @Bean
    public IClientNotify getClientNotify() {
        return new ClientNotify();
    }

    @Bean
    public CafeUserDetailService getCafeUserDetailService()
    {
        return new CafeUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
