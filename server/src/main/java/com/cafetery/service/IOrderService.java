package com.cafetery.service;

import com.cafetery.domain.Order;
import com.cafetery.domain.OrderItem;
import com.cafetery.domain.comp.CompOrder;
import com.cafetery.domain.wrapper.Result;

import java.util.List;

public interface IOrderService {

    Result<List<OrderItem>> addNewOrderItems(List<OrderItem> orders);

    void closeOrder(Long orderId);

    Result<OrderItem> addOrderItem(OrderItem order);

    void bindWaitressId(String garconId, Long orderId);

    List<CompOrder> findOpenByUserId(String userUuid);

    Order openNewOrder(String userUuid, Long tableId);
}
