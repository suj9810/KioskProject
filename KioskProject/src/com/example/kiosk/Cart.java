package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<MenuItem> menuItem;

    //생성자
    public Cart() {
        this.menuItem = new ArrayList<>();
    }

    //카테고리의 리스트 가져오기
    public void addItemCart(MenuItem menuItemList) {
        this.menuItem.add(menuItemList);
    }

    public List<MenuItem> getMenuItem() {
        return menuItem;
    }

    public boolean cartIsEmpty() {
        return menuItem.isEmpty();
    }

    //장바구니 담긴 목록 보여주기
    public void displayCart() {
        if (menuItem.isEmpty()) {
            System.out.println("장바구니가 비었습니다.");
        } else {
            System.out.println("장바구니 목록 : ");
            for (MenuItem item : menuItem) {
                System.out.println(item.Tarottype());
            }
        }
    }

    //카트 비우기
    public boolean removeCart() {
        this.menuItem.remove(0);
        System.out.println("진행중인 주문을 취소합니다.");
        return true;
    }

    public void clearCart() {
        menuItem.clear();
    }
}
