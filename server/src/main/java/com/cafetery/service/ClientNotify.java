package com.cafetery.service;

import com.cafetery.domain.CafeTable;
import com.cafetery.domain.Order;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class ClientNotify implements IClientNotify {

    @Autowired
    private SimpMessagingTemplate msgTemplate;

    @Override
    public void tableStatusChange(CafeTable table) {

        String json = new Gson().toJson(table);
        msgTemplate.convertAndSend("/topic/tables", json);
    }

    @Override
    public void orderUpdated(Order order) {
        String json = new Gson().toJson(order);
        msgTemplate.convertAndSendToUser(order.getUserId(),"/user/order", json);
    }
}
