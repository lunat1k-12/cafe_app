package com.cafetery.service;

import com.cafetery.constants.OrderStatus;
import com.cafetery.dao.OrderRepository;
import com.cafetery.domain.Order;
import com.cafetery.domain.wrapper.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Result<List<Order>> addNewOrders(List<Order> orders) {
        Result<List<Order>> result = new Result<>();

        try {
            populateSessionId(orders);
            orderRepo.saveAll(orders);
            result.setDomain(orders);
        } catch(Exception e) {
            result.setError(e.getMessage());
        }

        return result;
    }

    @Override
    public List<Order> getSessionOrders(String sessionId, String userId) {
        return orderRepo.findBySessionUuidAndUserId(sessionId, userId);
    }

    @Override
    public void closeOrder(String sessionId) {
        List<Order> orders = orderRepo.findOpenBySessionUuid(sessionId);

        if(CollectionUtils.isEmpty(orders)) {
           return;
        }

        for(Order order : orders) {
            order.setStatus(OrderStatus.CLOSED.toString());
        }

        orderRepo.saveAll(orders);
    }

    @Override
    public List<Order> addNewOrder(Order order) {
        // TODO: implement validation
        orderRepo.save(order);
        return orderRepo.findBySessionUuid(order.getSessionUuid());
    }

    @Override
    public void bindWaitressId(String garconId, String sessionUUid) {
        List<Order> orders = orderRepo.findOpenBySessionUuid(sessionUUid);

        for(Order order : orders) {
            order.setGarconId(garconId);
        }

        orderRepo.saveAll(orders);
    }

    private void populateSessionId(List<Order> orders) {
        if(!CollectionUtils.isEmpty(orders)) {
            String sessionId = UUID.randomUUID().toString();
            for(Order order : orders) {
               order.setSessionUuid(sessionId);
               order.setStatus(OrderStatus.OPEN.toString());
            }
        }
    }
}
