package com.cafetery.controllers;

import com.cafetery.domain.Order;
import com.cafetery.domain.OrderItem;
import com.cafetery.domain.wrapper.Result;
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

    @GetMapping("/{userUuid}/{tableId}/open")
    @ResponseBody
    public Order openNewOrder(@PathVariable("userUuid") String userUuid,
                              @PathVariable("tableId") Long tableId) {
        return orderService.openNewOrder(userUuid, tableId);
    }

    @GetMapping("/{userUuid}/get-open-orders")
    @ResponseBody
    public List<Order> getOpenOrders(@PathVariable("userUuid") String userUuid) {
        return orderService.findOpenByUserId(userUuid);
    }

    @PostMapping("/{orderId}/close")
    @ResponseStatus(HttpStatus.OK)
    public void closeOrder(@PathVariable("orderId") Long orderId) {
        orderService.closeOrder(orderId);
    }

    @PostMapping("/add-item")
    @ResponseBody
    public Result<OrderItem> addNewOrder(@RequestBody OrderItem order) {
        return orderService.addOrderItem(order);
    }

    @PostMapping("/{orderId}/{garconId}/bind-waitress")
    @ResponseStatus(HttpStatus.OK)
    public void bindWaitress(@PathVariable("garconId") String garconId,
                             @PathVariable("orderId") Long orderId) {
        orderService.bindWaitressId(garconId,orderId);
    }
}
