package com.cafetery.controllers;

import com.cafetery.domain.Order;
import com.cafetery.domain.wrapper.Result;
import com.cafetery.service.IOrderService;
import com.cafetery.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("/generate-user-id")
    @ResponseBody
    public Result<String> generateClientId() {
        return new Result<>(userService.generateClientId());
    }


    @PostMapping("/{userId}/new-order")
    @ResponseBody
    public Result<List<Order>> addOrders(@PathVariable("userId") String userId,
                                         @RequestBody List<Order> orders) {

        for(Order order : orders) {
            order.setUserId(userId);
        }

        return orderService.addNewOrders(orders);
    }

    @GetMapping("/{userId}/{sessionId}/session-orders")
    @ResponseBody
    public List<Order> getSessioOrders(@PathVariable("sessionId") String sessionId,
                                       @PathVariable("userId") String userId) {
        return orderService.getSessionOrders(sessionId, userId);
    }
}
