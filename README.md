## Kiosk-Project

키오스크 프로젝트

🖥️ 프로젝트 소개
---
키오스크 기능을 구현한 프로젝트입니다.

## 🕰️ 개발 기간

- 25.03.07금 - 25.03.14금

## 📌 프로젝트 목적

- 객체지향에 대한 개념을 이해하고, 흐름을 파악하는 것입니다.

<br/>

## 📖 개발 단계

### ✅ Lv.1 - 메뉴 출력 및 선택

- 숫자 입력 받은 후 메뉴 출력

### ✅ Lv.2 - <code>MenuItem</code> 클래스로 구조 관리

- <code>MenuItem</code> 클래스 생성 후 <code>List</code> 관리

### ✅ Lv.3 - <code>Kiosk</code> 클래스로 순서 제어

- <code>Kiosk</code> 클래스를 이용한 객체 지향 설계 및 순서 제어

### ✅ Lv.4 - <code>Menu</code> 클래스로 주문 내역 관리

- <code>Menu</code> 클래스를 가지고 <code>MenuItem</code>의 <code>List</code> 관리

### ✅ Lv.5 - 캡슐화 적용하기

- <code>MenuItem</code>, <code>List</code>, <code>Kiosk</code> 접근 제한 걸기
- Getter, Setter 메서드 사용해 데이터 관리

### ✅ Lv.6 - 장바구니 및 구매하기 기능 구현

- 장바구니 기능 구현
- 구매하기 기능 구현 ( + 작명 서비스 구매 시 랜덤 작명 구현 )

<br/>

---

<br/>

## 📃 프로젝트 구조


kiosk
    ├── Cart.java                   # 장바구니 기능
    ├── Kiosk.java                  # 키오스크 시스템
    ├── Main.java                   # 메인 실행 클래스 
    ├── Menu.java                   # 메뉴 카테고리
    ├── MenuItem.java               # 메뉴 아이템 정보 
    ├── Order.java                  # 주문 정보 관리 
    ├── RandomName.java             # 작명 시스템 기능
