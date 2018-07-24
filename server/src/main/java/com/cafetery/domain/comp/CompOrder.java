package com.cafetery.domain.comp;

import com.cafetery.domain.Order;
import com.cafetery.domain.OrderItem;

import java.util.List;

public class CompOrder extends Order {

    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
