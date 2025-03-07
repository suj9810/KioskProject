package com.example.kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner 생성
        Scanner sc = new Scanner(System.in);
        //생성자 호출
        MenuItem today = new MenuItem("오늘의 운세", "3,000", "카드 한장으로 오늘의 운세를 점쳐드립니다.");
        MenuItem love = new MenuItem("연애운", "8,000", "당신의 연애 고민을 해결해드립니다.");
        MenuItem money = new MenuItem("금전운", "10,000", "올해 당신의 금전운을 봐드립니다.");
        //List 선언
        ArrayList<MenuItem> itemList = new ArrayList<>();
        //MenuItem을 List에 삽입
        itemList.add(today);
        itemList.add(love);
        itemList.add(money);

        System.out.println("\n[ 은주의 타로가게 ]");
        //메뉴 종류
        System.out.println("TAROT MENU");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < itemList.size(); i++) {
            MenuItem menu = itemList.get(i);
            System.out.println(i + 1 + ". " + menu.Tarottype());
        }
        System.out.println("--------------------------------------------------------------------------");
        //종료
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
    }
}
