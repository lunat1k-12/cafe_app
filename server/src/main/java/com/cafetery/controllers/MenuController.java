package com.cafetery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/")
public class MenuController {

    @GetMapping("/menu")
    @ResponseBody
    public String getMenu() {
        return "Test Value";
    }
}
