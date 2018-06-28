package com.cafetery.dao;

import com.cafetery.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepository extends CrudRepository<Order, Long> {
}
