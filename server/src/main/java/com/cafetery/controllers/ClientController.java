package com.cafetery.controllers;

import com.cafetery.dao.UserRepository;
import com.cafetery.domain.User;
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

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/generate-user-id")
    @ResponseBody
    public Result<String> generateClientId() {
        return new Result<>(userService.generateClientId());
    }

    @GetMapping("/all-users")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

}
