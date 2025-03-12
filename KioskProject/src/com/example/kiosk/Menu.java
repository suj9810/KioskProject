package com.example.kiosk;

import java.util.ArrayList;

public class Menu {
    private String name; //메뉴 카테고리 이름
    private ArrayList<MenuItem> menuItemList = new ArrayList<>(); //메뉴 항목 리스트

    //생성자
    public Menu(String name) {
        this.name = name;
    }
    //카테고리의 이름 반환
    public String getName() {
        return name;
    }
    //카테고리의 리스트 가져오기
    public void add(MenuItem menuItem){
        this.menuItemList.add(menuItem);
    }
    //카테고리 리스트 반환
    public ArrayList<MenuItem> getMenuItemList() {
        return menuItemList;
    }
}
