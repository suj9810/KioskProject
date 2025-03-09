package com.example.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //kiosk 객체 생성
        Kiosk kiosk = new Kiosk();
        //생성자 호출
        MenuItem today = new MenuItem("오늘의 운세", "3,000", "카드 한장으로 오늘의 운세를 점쳐드립니다.");
        MenuItem love = new MenuItem("연애운", "8,000", "당신의 연애 고민을 해결해드립니다.");
        MenuItem money = new MenuItem("금전운", "10,000", "올해 당신의 금전운을 봐드립니다.");
        
        //키오스크 시작
        kiosk.start(today, love, money);
        //메뉴 선택
        kiosk.choice();
        //키오스크 종료
        kiosk.close();
    }
}
