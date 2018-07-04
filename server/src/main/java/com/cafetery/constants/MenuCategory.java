package com.cafetery.constants;

public enum MenuCategory {

    CONCTAIL("contails"), FOOD("food");

    private String shortName;

    MenuCategory(String shortName) {
       this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public  static MenuCategory getByShortName(String shortName) {
        MenuCategory[] values = MenuCategory.values();

        for(MenuCategory cat : values)
        {
            if(cat.getShortName().equals(shortName)) {
                return cat;
            }
        }

        return null;
    }
}
