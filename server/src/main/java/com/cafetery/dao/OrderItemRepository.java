package com.cafetery.dao;

import com.cafetery.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Long orderId);

}
