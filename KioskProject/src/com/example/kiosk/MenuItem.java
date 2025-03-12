package com.example.kiosk;

public class MenuItem {
//    private final String tarottype;
    private String name;
    private String price;
    private String explain;

    public MenuItem(String name, String price, String explain) {
        this.name = name;
        this.price = price;
        this.explain = explain;
    }

    public String Tarottype() {
        return name + " | " + price + "원 | " + explain;
    }
}
