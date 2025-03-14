package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<MenuItem> menuItem;
    private Double totalPrice;

    //생성자
    public Order() {
        this.menuItem = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    //카테고리의 리스트 가져오기
    public void addCartOrder(MenuItem menuItemList) {
        this.menuItem.add(menuItemList);
        this.totalPrice += Double.parseDouble(menuItemList.getPrice().replace(",", ""));
    }

    //주문 화면 노출
    public void displayPayment() {
        if (menuItem.isEmpty()) {
            System.out.println("주문 내역이 비어있습니다.");
        } else {
            System.out.println("================================");
            System.out.println("[ Orders ]");
            for (MenuItem item : menuItem) {
                System.out.println(item.Tarottype());
            }
            System.out.println("================================");
            System.out.println("[ Total ]");
            System.out.println(String.format("%,.0f", totalPrice) + "원");
        }
    }


    //총 금액 반환
    public Double getTotalPrice() {
        return totalPrice;
    }
}
