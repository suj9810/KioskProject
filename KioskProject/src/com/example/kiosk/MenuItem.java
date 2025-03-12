package com.example.kiosk;

public class MenuItem {
    //메뉴 이름
    private String name;
    //메뉴 가격
    private String price;
    //메뉴 설명
    private String explain;
    //생성자 : 리스트 초기화
    public MenuItem(String name, String price, String explain) {
        this.name = name;
        this.price = price;
        this.explain = explain;
    }
    //문자열 반환
    public String Tarottype() {
        return name + " | " + price + "원 | " + explain;
    }
    //메뉴 이름 반환
    public String getName() {
        return name;
    }
    //메뉴 가격 반환
    public String getPrice() {
        return price;
    }
    //메뉴 설명 반환
    public String getExplain() {
        return explain;
    }
}
