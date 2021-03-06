package com.cafetery.service;

import com.cafetery.constants.OrderItemStatus;
import com.cafetery.constants.OrderStatus;
import com.cafetery.dao.OrderItemRepository;
import com.cafetery.dao.OrderRepository;
import com.cafetery.domain.Order;
import com.cafetery.domain.OrderItem;
import com.cafetery.domain.comp.CompOrder;
import com.cafetery.domain.wrapper.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private IClientNotify clientNotify;

    @Override
    public Result<List<OrderItem>> addNewOrderItems(List<OrderItem> orders) {
        Result<List<OrderItem>> result = new Result<>();
        orders.forEach(o -> o.setStatus(OrderItemStatus.OPEN.name()));

        try {
            orderItemRepo.saveAll(orders);
            result.setDomain(orders);
        } catch(Exception e) {
            result.setError(e.getMessage());
        }

        return result;
    }

    @Override
    public void closeOrder(Long orderId) {
        Optional<Order> optional = orderRepo.findById(orderId);

        if(!optional.isPresent()) {
           return;
        }
        Order order = optional.get();
        order.setStatus(OrderStatus.CLOSED.toString());
        order.setCloseDate(new Date());

        orderRepo.save(order);
        clientNotify.orderUpdated(order);
    }

    @Override
    public Result<OrderItem> addOrderItem(OrderItem order) {
        // TODO: implement validation
        order.setStatus(OrderItemStatus.OPEN.name());
        Result<OrderItem> result = new Result<>();
        result.setDomain(orderItemRepo.save(order));
        return result;
    }

    @Override
    public void bindWaitressId(String garconId, Long orderId) {
        Optional<Order> optional = orderRepo.findById(orderId);

        if(!optional.isPresent()) {
            return;
        }
        Order order = optional.get();
        order.setGarconId(garconId);

        orderRepo.save(order);
        clientNotify.orderUpdated(order);
    }

    @Override
    public List<CompOrder> findOpenByUserId(String userUuid) {
        List<Order> orders = orderRepo.findOpenByUserId(userUuid);
        if(CollectionUtils.isEmpty(orders)) {
            return Collections.emptyList();
        }

        return orders.stream().map(dbOrder -> {
            CompOrder comp = new CompOrder();
            BeanUtils.copyProperties(dbOrder, comp);
            comp.setOrderItems(orderItemRepo.findByOrderId(dbOrder.getId()));
            return comp;
        }).collect(Collectors.toList());
    }

    @Override
    public Order openNewOrder(String userUuid, Long tableId) {
        Order order = new Order();
        order.setUserId(userUuid);
        order.setStatus(OrderStatus.OPEN.name());
        order.setTableId(tableId);
        order.setOrderDate(new Date());
        return orderRepo.save(order);
    }

}
