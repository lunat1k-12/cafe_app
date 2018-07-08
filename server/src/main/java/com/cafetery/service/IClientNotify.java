package com.cafetery.service;

import com.cafetery.domain.CafeTable;
import com.cafetery.domain.Order;

public interface IClientNotify {
    void tableStatusChange(CafeTable table);

    void orderUpdated(Order order);
}
