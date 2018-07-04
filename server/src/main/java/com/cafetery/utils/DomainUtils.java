package com.cafetery.utils;

import com.cafetery.constants.MenuCategory;
import com.cafetery.domain.MenuItem;

public class DomainUtils {

    public static boolean verifyCategory(MenuItem item) {
        return verifyCategory(item.getCategory());
    }

    public static boolean verifyCategory(String category) {
        try{
            MenuCategory.valueOf(category);
        } catch(Exception ex) {
            return false;
        }

        return true;
    }
}
