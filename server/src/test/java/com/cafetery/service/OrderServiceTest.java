package com.cafetery.service;

import com.cafetery.dao.OrderItemRepository;
import com.cafetery.dao.OrderRepository;
import com.cafetery.domain.Order;
import com.cafetery.domain.OrderItem;
import com.cafetery.domain.comp.CompOrder;
import com.cafetery.domain.wrapper.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepo;

    @Mock
    private OrderItemRepository orderItemRepo;

    @Mock
    private IClientNotify clientNotify;

    @InjectMocks
    private OrderService service;

    @Test
    public void addNewOrderItems_hp() {

        List<OrderItem> orders = Arrays.asList(new OrderItem(), new OrderItem());

        Result<List<OrderItem>> res = service.addNewOrderItems(orders);

        verify(orderItemRepo).saveAll(orders);
        assertNotNull(res.getDomain());
    }

    @Test
    public void closeOrder_hp() {

        Long orderId = 12L;
        Optional<Order> optional = Optional.of(new Order());

        when(orderRepo.findById(orderId)).thenReturn(optional);

        service.closeOrder(orderId);

        verify(orderRepo).save(any(Order.class));
        verify(clientNotify).orderUpdated(any(Order.class));
    }

    @Test
    public void addOrderItem_hp() {

        OrderItem order = new OrderItem();

        when(orderItemRepo.save(any(OrderItem.class))).thenReturn(order);

        Result<OrderItem> res = service.addOrderItem(order);

        assertNotNull(res.getDomain());
        verify(orderItemRepo).save(any(OrderItem.class));
    }

    @Test
    public void bindWaitressId_recordPresents() {

        String garconId = "garcon";
        Long orderId = 12L;

        when(orderRepo.findById(orderId)).thenReturn(Optional.of(new Order()));

        service.bindWaitressId(garconId,orderId);

        verify(orderRepo).save(any(Order.class));
        verify(clientNotify).orderUpdated(any(Order.class));
    }

    @Test
    public void bindWaitressId_recordNotExists() {

        String garconId = "garcon";
        Long orderId = 12L;

        service.bindWaitressId(garconId,orderId);

        verify(orderRepo,never()).save(any(Order.class));
        verify(clientNotify,never()).orderUpdated(any(Order.class));
    }

    @Test
    public void findOpenByUserId_hp() {

        String userUuid = "userUuid";
        Order order = new Order();
        order.setId(12L);

        when(orderRepo.findOpenByUserId(userUuid)).thenReturn(Collections.singletonList(order));
        when(orderItemRepo.findByOrderId(order.getId())).thenReturn(Collections.singletonList(new OrderItem()));

        List<CompOrder> res = service.findOpenByUserId(userUuid);

        assertNotNull(res);
        assertFalse(CollectionUtils.isEmpty(res));
        assertFalse(CollectionUtils.isEmpty(res.get(0).getOrderItems()));
        verify(orderRepo).findOpenByUserId(userUuid);
        verify(orderItemRepo).findByOrderId(order.getId());
    }

    @Test
    public void findOpenByUserId_emptyRes() {

        String userUuid = "userUuid";
        Order order = new Order();
        order.setId(12L);

        List<CompOrder> res = service.findOpenByUserId(userUuid);

        assertNotNull(res);
        assertTrue(CollectionUtils.isEmpty(res));
        verify(orderRepo).findOpenByUserId(userUuid);
        verify(orderItemRepo,never()).findByOrderId(order.getId());
    }

    @Test
    public void openNewOrder_hp() {

        String userUuid = "userUuid";
        Long tableId = 12L;

        when(orderRepo.save(any(Order.class))).thenReturn(new Order());

        Order res = service.openNewOrder(userUuid, tableId);

        assertNotNull(res);
    }
}
