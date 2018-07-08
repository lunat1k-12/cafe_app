package com.cafetery.configuration;

import com.cafetery.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
