package com.cafetery.dao;

import com.cafetery.domain.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
    List<MenuItem> findAllByCategory(String category);

    void deleteById(Long id);
}
