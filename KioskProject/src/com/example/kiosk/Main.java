package com.example.kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //kiosk 객체 생성
//        Kiosk kiosk = new Kiosk(menuList, sc);
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> menuList = new ArrayList<>();
        Kiosk kiosk = new Kiosk(menuList, sc);

        Menu tarot = new Menu("타로");
        Menu fate = new Menu("사주");
        Menu naming = new Menu("작명");

        //생성자 호출
        tarot.add(new MenuItem("타로", "3,000", "카드 한장으로 오늘의 운세를 점쳐드립니다."));
        tarot.add(new MenuItem("연애운", "8,000", "당신의 연애 고민을 해결해드립니다."));
        tarot.add(new MenuItem("금전운", "10,000", "올해 당신의 금전운을 봐드립니다."));
        fate.add(new MenuItem("사주", "10,000", "당신의 운명을 봐드립니다"));
        naming.add(new MenuItem("작명", "10,000", "외국인의 한국 이름을 지어드립니다."));

        //메뉴 선택
        kiosk.choice(tarot, fate, naming);
    }
}
