package com.cafetery.dao;

import com.cafetery.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT * FROM ORDERS WHERE USER_ID = :userId AND STATUS = 'OPEN'", nativeQuery = true)
    List<Order> findOpenByUserId(@Param("userId") String userId);
}
