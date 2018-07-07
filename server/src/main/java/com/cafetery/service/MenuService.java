package com.cafetery.service;

import com.cafetery.constants.MenuCategory;
import com.cafetery.dao.MenuItemRepository;
import com.cafetery.domain.MenuItem;
import com.cafetery.domain.wrapper.Result;
import com.cafetery.utils.DomainUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuService implements IMenuService {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @Override
    public List<MenuItem> getMenu(String shortCategory) {
        MenuCategory category = MenuCategory.getByShortName(shortCategory);
        return menuItemRepo.findAllByCategory(category.name());
    }

    @Override
    public Result<MenuItem> addMenuItem(MenuItem item) {

        Result<MenuItem> result = new Result<>();
        if(DomainUtils.verifyCategory(item)) {
            result.setDomain(menuItemRepo.save(item));
        } else {
            result.setError("Failed to add item.");
        }

        return result;
    }

    @Override
    public void deleteItem(Long id) {
        menuItemRepo.deleteById(id);
    }
}
