package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    private final ArrayList<Menu> menuList;
    private ArrayList<MenuItem> menuItemList;
    private final Scanner sc;

    //생성자
    public Kiosk(ArrayList<Menu> menuList, Scanner sc) {
        this.menuList = menuList;
        this.sc = sc;
    }

    //시작
    public void start(Menu tarot, Menu fate, Menu naming) {
        displayMain(tarot, fate, naming);
    }

    //메뉴 선택
    public void choice(Menu tarot, Menu fate, Menu naming) {
        boolean exitFlag = true;
        boolean exitFlag2 = true; //true면 로비에서 받는거 / false면 메뉴에서 받는거
        int index;
        start(tarot, fate, naming);
            while (exitFlag) {
                index = indexValidation();
                if (index == 0) { //종료 및 뒤로가기 선택
                    if (exitFlag2) {
                        exitFlag = false;
                    } else {
                        start(tarot, fate, naming); //여기가 로비입니당!
                        exitFlag2 = true;
                    }
                } else if (index == 1) {
                    menuItemList = tarot.getMenuItemList();
                    getTarotList();
                    System.out.println("0. 뒤로가기");
                    exitFlag2 = false; //여기가 카테고리 선택하는 창인지 판단
                } else if (index == 2) {
                    menuItemList = fate.getMenuItemList();
                    getTarotList();
                    System.out.println("0. 뒤로가기");
                    exitFlag2 = false;
                } else if (index == 3) {
                    menuItemList = naming.getMenuItemList();
                    getTarotList();
                    System.out.println("0. 뒤로가기");
                    exitFlag2 = false;
                } else {
                    System.out.println("메뉴 선택을 다시 해주세요.");
                }
            }
    }
    //로딩 화면
    private void displayMain(Menu tarot, Menu fate, Menu naming) {
        System.out.println("\n은주의 타로 가게에 오신 것을 환영합니다.");
        System.out.println("\n타로 메뉴 로딩중....");

        thread();

        System.out.println("\n[ 은주의 타로가게 ]");

        //메뉴 종류
        System.out.println("TAROT MENU");
        System.out.println("--------------------------------------------------------------------------");
        menuAddCategory(tarot, fate, naming);

        System.out.println("0. 종료");
        System.out.println("--------------------------------------------------------------------------");
    }

    //메뉴 카테고리
    private void menuAddCategory(Menu tarot, Menu fate, Menu naming) {
        if (menuList.isEmpty()) {
            menuList.add(tarot);
            menuList.add(fate);
            menuList.add(naming);
        }
        for (int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);
            System.out.println(i + 1 + ". " + menu.getName());
        }
    }

    //Thread
    private void thread() {
        //Thread 이용, 메뉴 5초 후 출력
        try {
            for (int i = 1; i <= 5; i++) {
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
            int indexInput = indexValidation();
            if (indexInput >= 0 && indexInput <= menuItemList.size()){
                MenuItem selectCategory = menuItemList.get(-1);
                System.out.println("선택한 메뉴 : " + selectCategory.Tarottype());
            } else {
                System.out.println("잘못된 선택입니다.");
            }

        } else {
            System.out.println("타로 리스트가 비어 있습니다.");
        }
    }

    //입력 숫자 유효성 검사
    private int indexValidation() {
        while (true) {
            System.out.println("메뉴의 번호를 입력해주세요.");
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