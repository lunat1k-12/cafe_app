package com.cafetery.dao;

import com.cafetery.domain.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
}
