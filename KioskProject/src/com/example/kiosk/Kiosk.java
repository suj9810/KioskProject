package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    //메뉴 카테고리 리스트
    private final ArrayList<Menu> menuList;
    //메뉴 아이템 리스트
    private ArrayList<MenuItem> menuItemList;
    //스캐너 입력
    private final Scanner sc;
    //장바구니
    private final Cart cart;

    int index;

    //생성자 : 객체 초기화
    public Kiosk(ArrayList<Menu> menuList, Scanner sc, Cart cart) {
        this.menuList = menuList;
        this.sc = sc;
        this.cart = cart;
    }

    //키오스크 시작
    public void start(Menu tarot, Menu fate, Menu naming) {
        boolean exitFlag = true; //키오스크 종료
        boolean isLobby = true; //로비 화면 여부
        while (exitFlag) {
            displayMain(tarot, fate, naming); //메인
            index = indexValidation(); //유호 숫자 확인
            if (index == 0) { //종료 및 뒤로가기 선택
                if (isLobby) {
                    exitFlag = false; //로비 상태 0 입력 시 종료
                } else {
                    start(tarot, fate, naming); //여기가 로비입니당!
                    isLobby = true;
                }
            } else if (index == 1) { //타로 메뉴 선택
                menuItemList = tarot.getMenuItemList();
                System.out.println("0. 뒤로가기");
                getTarotList(); //메뉴 출력
                isLobby = false; //여기가 카테고리 선택하는 창인지 판단
            } else if (index == 2) { // 운세 메뉴 선택
                menuItemList = fate.getMenuItemList();
                System.out.println("0. 뒤로가기");
                getTarotList();
                isLobby = false;
            } else if (index == 3) { // 작명 메뉴 선택
                menuItemList = naming.getMenuItemList();
                System.out.println("0. 뒤로가기");
                getTarotList();
                isLobby = false;
            } else if (index == 4) { //주문 시작
                cart.displayCart(); // 장바구니 목록
                if (!cart.cartIsEmpty()) {
                    System.out.println("정말로 주문하시겠습니까?");
                    shoppingPayment();
                } else {
                    System.out.println("장바구니가 비어 있습니다.");
                }
            } else if (index == 5) { // 주문 취소
                cart.removeCart();
            } else {
                System.out.println("메뉴 선택을 다시 해주세요.");
            }
        }
    }

    //메인 화면
    private void displayMain(Menu tarot, Menu fate, Menu naming) {
        System.out.println("\n은주의 타로 가게에 오신 것을 환영합니다.");
        System.out.println("\n타로 메뉴 로딩중....");
        thread(); //1초 딜레이 주기

        //메인 화면 출력
        System.out.println("\n[ 은주의 타로가게 ]");
        System.out.println("TAROT MENU");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("[ MAIN MENU ]");
        menuAddCategory(tarot, fate, naming); //카테고리 목록 추가 부분
        System.out.println("0. 종료");
        System.out.println("--------------------------------------------------------------------------");

        //장바구니에 물건 담길 시 출력
        if (!cart.cartIsEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
            System.out.println("--------------------------------------------------------------------------");
        }

    }

    //메뉴 카테고리 출력
    private void menuAddCategory(Menu tarot, Menu fate, Menu naming) {
        if (menuList.isEmpty()) { //첫 메뉴 노출 시 add
            menuList.add(tarot);
            menuList.add(fate);
            menuList.add(naming);
        }
        //메뉴 출력
        for (int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);
            System.out.println(i + 1 + ". " + menu.getName());
        }
    }

    //Thread : 1초 지연
    private void thread() {
        try {
            for (int i = 1; i <= 1; i++) {
                Thread.sleep(1000); // 1초 지연
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //카테고리 리스트
    private void getTarotList() {
        if (!menuItemList.isEmpty()) {
            for (int i = 0; i < menuItemList.size(); i++) {
                MenuItem item = menuItemList.get(i);
                System.out.println(i + 1 + ". " + item.Tarottype());
            }
            //선택한 메뉴 보여주기
            int indexInput = indexValidation(); //숫자 유효성 검사
            if (indexInput != 0) {
                if (indexInput >= 0 && indexInput <= menuItemList.size()) {
                    MenuItem selectCategory = menuItemList.get(indexInput - 1);
                    System.out.println("선택한 메뉴 : " + selectCategory.Tarottype());
                    shoppingCart(selectCategory); //장바구니에 추가하기
                } else {
                    System.out.println("잘못된 선택입니다.");
                }
            }
        } else {
            System.out.println("타로 리스트가 비어 있습니다.");
        }
    }

    //장바구니 구현
    private void shoppingCart(MenuItem selectedItem) {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인 / 2. 취소 ");
        while (true) {
            index = indexValidation();
            if (index == 1) {
                cart.addItemCart(selectedItem); //장바구니 추가
                System.out.println(selectedItem.getName() + "이(가) 장바구니에 추가되었습니다.");
                break;
            } else if (index == 2) {
                System.out.println("장바구니 추가가 취소되었습니다.");
                break;
            } else {
                System.out.println("1. 확인 / 2. 취소 중에서 선택해주세요.");
            }
        }
    }

    //주문 하기
    private void shoppingPayment() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("1. 주문 / 2. 메뉴판 ");
        int input = indexValidation();
        if (input == 1) {
            Order currentOrder = new Order();
            boolean hasNamingService = false;
            for (MenuItem item : cart.getMenuItem()) {
                currentOrder.addCartOrder(item);

                if (item.getName().equals("작명")) { //
                    hasNamingService = true;
                }
            }
            System.out.println("주문 내역:");
            currentOrder.displayPayment();
            System.out.println("주문이 완료되었습니다!");
            if (hasNamingService) { //작명 결제 완료 시 이름 짓기 시작
                randoNaming();
            }
            cart.clearCart(); //주문 완료 후 장바구니 비우기
        } else if (index == 2) {
            getTarotList();
        }
    }

    //작명
    private void randoNaming() {
        RandomName randomName = new RandomName();
        System.out.println("성을 입력해주세요 : ");
        String lastName = sc.nextLine().trim();
        String fullName = randomName.createRandomName(lastName);
        System.out.println("당신의 이름은 : " + fullName + "입니다.");
    }

    //입력 숫자 유효성 검사
    private int indexValidation() {
        while (true) {
            try {
                int inputIndex = sc.nextInt();
                sc.nextLine();
                if (inputIndex >= 0) {
                    return inputIndex;
                } else {
                    System.out.println("0 이상의 숫자를 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                sc.nextLine(); // 잘못된 입력 삭제
            }
        }
    }

}