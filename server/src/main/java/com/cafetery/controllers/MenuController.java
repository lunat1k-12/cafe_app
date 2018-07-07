package com.cafetery.controllers;

import com.cafetery.constants.MenuCategory;
import com.cafetery.dao.MenuItemRepository;
import com.cafetery.domain.MenuItem;
import com.cafetery.domain.wrapper.Result;
import com.cafetery.utils.DomainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @GetMapping("/{category}")
    @ResponseBody
    public List<MenuItem> getMenu(@PathVariable("category") String shortCategory) {
        MenuCategory category = MenuCategory.getByShortName(shortCategory);
        return menuItemRepo.findAllByCategory(category.name());
    }

    @PostMapping("/item")
    @ResponseBody
    public Result<MenuItem> addMenuItem(@RequestBody MenuItem item) {

        Result<MenuItem> result = new Result<>();
        if(DomainUtils.verifyCategory(item)) {
            result.setDomain(menuItemRepo.save(item));
        } else {
            result.setError("Failed to add item.");
        }

        return result;
    }

    @DeleteMapping("/item/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("id") Long id) {
        menuItemRepo.deleteById(id);
    }
}
