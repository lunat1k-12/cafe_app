package com.cafetery.service;

import com.cafetery.domain.Order;
import com.cafetery.domain.wrapper.Result;

import java.util.List;

public interface IOrderService {

    Result<List<Order>> addNewOrders(List<Order> orders);

    List<Order> getSessionOrders(String sessionId, String userId);

    void closeOrder(String sessionId);

    List<Order> addNewOrder(Order order);
}
