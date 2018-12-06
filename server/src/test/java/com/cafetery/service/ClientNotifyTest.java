package com.cafetery.service;

import com.cafetery.domain.CafeTable;
import com.cafetery.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientNotifyTest {

    @Mock
    private SimpMessagingTemplate msgTemplate;

    @InjectMocks
    private ClientNotify notify;

    @Test
    public void tableStatusChange_hp() {

        CafeTable table = new CafeTable();

        notify.tableStatusChange(table);

        verify(msgTemplate).convertAndSend(anyString(),anyString());
    }

    @Test
    public void orderUpdated_hp() {

        Order order = new Order();
        order.setUserId("userId");

        notify.orderUpdated(order);

        verify(msgTemplate).convertAndSendToUser(anyString(),anyString(),anyString());
    }
}
