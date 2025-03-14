package com.example.kiosk;

import java.util.Random;

public class RandomName {
    private String[] firstName;
    private Random random;

    public RandomName() {
        this.firstName = new String[]{"하율", "정민", "지민", "태연", "주영", "연우", "지우", "라온", "주현", "해온", "서진", "하늘", "하온", "다온", "바다", "우연", "연오", "현솔",
                "해랑", "주원", "민준", "우주", "은율", "이든", "유찬", "현솔", "도울", "지안", "하람", "두리", "시온", "봄", "여름", "가을", "겨울"};
        this.random = new Random();
    }

    public String createRandomName(String lastName) {
        String randomFirstName = firstName[random.nextInt(firstName.length)];
        return lastName + randomFirstName;
    }
}

