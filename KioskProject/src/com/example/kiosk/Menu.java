package com.example.kiosk;

import java.util.ArrayList;

public class Menu {
    String name;
    ArrayList<MenuItem> menuItemList = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void add(MenuItem menuItem){
        this.menuItemList.add(menuItem);
    }
    public ArrayList<MenuItem> getMenuItemList() {
        return menuItemList;
    }
}
