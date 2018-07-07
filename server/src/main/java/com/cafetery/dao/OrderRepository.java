package com.cafetery.dao;

import com.cafetery.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findBySessionUuidAndUserId(String sessionId, String userId);

    @Query(value = "SELECT * FROM Order WHERE SESSION_UUID = :sessionUuid AND STATUS = 'OPEN'", nativeQuery = true)
    List<Order> findOpenBySessionUuid(@Param("sessionUuid") String sessionUuid);

    List<Order> findBySessionUuid(String sessionUuid);
}
