package com.cafetery.controllers;

import com.cafetery.domain.wrapper.Result;
import com.cafetery.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IUserService userService;

    @GetMapping("/generate-user-id")
    @ResponseBody
    public Result<String> generateClientId() {
        return new Result<>(userService.generateClientId());
    }

}
