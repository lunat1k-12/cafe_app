package com.cafetery.controllers;

import com.cafetery.domain.Order;
import com.cafetery.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/{sessionUuid}/close")
    @ResponseStatus(HttpStatus.OK)
    public void closeOrder(@PathVariable("sessionUuid") String sessionUuid) {
        orderService.closeOrder(sessionUuid);
    }

    @PostMapping("/{sessionUuid}/add-item")
    @ResponseBody
    public List<Order> addNewOrder(@PathVariable String sessionUuid,
                                   @RequestBody Order order) {
        order.setSessionUuid(sessionUuid);
        return orderService.addNewOrder(order);
    }
}
