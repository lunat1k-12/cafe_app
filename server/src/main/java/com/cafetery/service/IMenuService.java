package com.cafetery.service;

import com.cafetery.domain.MenuItem;
import com.cafetery.domain.wrapper.Result;

import java.util.List;

public interface IMenuService {

    List<MenuItem> getMenu(String shortCategory);

    Result<MenuItem> addMenuItem(MenuItem item);

    void deleteItem(Long id);
}
