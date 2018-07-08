package com.cafetery.controllers;

import com.cafetery.domain.User;
import com.cafetery.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService userService;

    @PostMapping("/waitress/register")
    @ResponseBody
    public User registerWaitress(@RequestBody User user) {
        return userService.registerWaitress(user);
    }
}
