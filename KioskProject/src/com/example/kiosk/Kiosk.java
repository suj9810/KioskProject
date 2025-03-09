package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    //List 선언
    ArrayList<MenuItem> itemList = new ArrayList<>();

    //Scanner 생성
    Scanner sc = new Scanner(System.in);

    //실행
    public void start(MenuItem today, MenuItem love, MenuItem money) {
        System.out.println("\n은주의 타로 가게에 오신 것을 환영합니다.");
        System.out.println("\n타로 메뉴 로딩중....");

        //Thread 이용, 메뉴 5초 후 출력
        try {
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(1000); // 1초 지연
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n[ 은주의 타로가게 ]");

        //MenuItem을 List에 삽입
        itemList.add(today);
        itemList.add(love);
        itemList.add(money);

        //메뉴 종류
        System.out.println("TAROT MENU");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < itemList.size(); i++) {
            MenuItem menu = itemList.get(i);
            System.out.println(i + 1 + ". " + menu.Tarottype());
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    //메뉴 선택
    public void choice() {

    }

    //종료
    public void close() {
        try {
            while (true) {
                System.out.println("0을 입력하면 종료됩니다.");
                int index = sc.nextInt();
                if (index == 0) {
                    sc.close();
                    return;
                } else {
                    System.out.println("타로를 다시 시작합니다.");
                }
            }
        } catch(InputMismatchException e) {
            System.out.println("숫자만 입력 해주세요.");
        }
    }
}
