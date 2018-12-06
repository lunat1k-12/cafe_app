package com.cafetery.service;

import com.cafetery.constants.MenuCategory;
import com.cafetery.dao.MenuItemRepository;
import com.cafetery.domain.MenuItem;
import com.cafetery.domain.wrapper.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceTest {

    @Mock
    private MenuItemRepository menuItemRepo;

    @InjectMocks
    private MenuService service;

    @Test
    public void getMenu_hp() {

        String shortCategory = "cocktails";

        when(menuItemRepo.findAllByCategory(MenuCategory.COCKTAILS.name()))
                .thenReturn(Collections.singletonList(new MenuItem()));

        List<MenuItem> items = service.getMenu(shortCategory);

        assertNotNull(items);
        assertFalse(CollectionUtils.isEmpty(items));
        verify(menuItemRepo).findAllByCategory(MenuCategory.COCKTAILS.name());
    }

    @Test
    public void addMenuItem_hp() {

        MenuItem item = new MenuItem();
        item.setCategory("COCKTAILS");

        when(menuItemRepo.save(item)).thenReturn(item);

        Result<MenuItem> res = service.addMenuItem(item);

        assertNull(res.getError());
        assertNotNull(res.getDomain());
        verify(menuItemRepo).save(item);
    }

    @Test
    public void addMenuItem_invalidCategory() {

        MenuItem item = new MenuItem();
        item.setCategory("Invalid");

        Result<MenuItem> res = service.addMenuItem(item);

        assertNotNull(res.getError());
        assertNull(res.getDomain());
        verify(menuItemRepo,never()).save(item);
    }

    @Test
    public void deleteItem_hp() {

        Long id = 12L;

        service.deleteItem(id);

        verify(menuItemRepo).deleteById(id);
    }

    @Test
    public void editMenuItem_hp() {

        MenuItem item = new MenuItem();
        when(menuItemRepo.save(item)).thenReturn(item);

        Result<MenuItem> res = service.editMenuItem(item);

        assertNotNull(res.getDomain());
        verify(menuItemRepo).save(item);
    }
}
