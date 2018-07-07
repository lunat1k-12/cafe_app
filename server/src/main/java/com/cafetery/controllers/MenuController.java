package com.cafetery.controllers;

import com.cafetery.domain.MenuItem;
import com.cafetery.domain.wrapper.Result;
import com.cafetery.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping("/{category}")
    @ResponseBody
    public List<MenuItem> getMenu(@PathVariable("category") String shortCategory) {
        return menuService.getMenu(shortCategory);
    }

    @PostMapping("/item")
    @ResponseBody
    public Result<MenuItem> addMenuItem(@RequestBody MenuItem item) {
        return menuService.addMenuItem(item);
    }

    @DeleteMapping("item/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("id") Long id) {
        menuService.deleteItem(id);
    }
}
