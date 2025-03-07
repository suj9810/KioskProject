package com.example.kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner 생성
        Scanner sc = new Scanner(System.in);
        //변수
        String today = new String("1. 오늘의 운세 | " + "3,000원 | " + "카드 한장으로 오늘의 운세를 점쳐드립니다.");
        String love = new String("2. 연애운 | " + "8,000원 | " + "당신의 연애 고민을 해결해드립니다.");
        String money = new String("3. 금전운 | " + "10,000원 | " + "올해 당신의 금전운을 봐드립니다.");

        //반복문 시작
        while (true) {
            System.out.println("\n[ 은주의 타로가게 ]");
            //메뉴 종류
            System.out.println("TAROT MENU");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println(today);
            System.out.println(love);
            System.out.println(money);
            System.out.println("--------------------------------------------------------------------------");

            System.out.println("0을 입력하면 종료됩니다.");

            int index = sc.nextInt();
            if (index == 0) {
                break;
            } else {
                System.out.println("타로를 다시 시작합니다.");
            }
        }

    }
}
