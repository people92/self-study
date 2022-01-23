package com.study.example.java.effectivejava;

import lombok.NoArgsConstructor;


/*
* Item 1 : 생성자 대신 정적 팩터리 메서드를 고려하라
* */
public class Item1 {

    private String itemId;
    private String itemNm;

    private final static Item1 GUCCI = new Item1("10001", "구찌");

    private Item1() {

    }
    public Item1(String itemId, String itemNm) {
        this.itemId = itemId;
        this.itemNm = itemNm;
    }
    /*
    * 장점 1 : 이름을 가질 수 있다. -> 생성자 자체만으로는 반환될 객체의 특성을 설명하기 힘들다.
    * 동일한 타입의 파라미터로는 오직 생성자 1개만 만들수밖에 없다. 하지만 정적 팩토리 메서드로는 제약이 없음.
    * */
    public static Item1 initItem(String itemId, String itemNm) {
        Item1 item1 = new Item1();
        item1.itemId = itemId;
        item1.itemNm = itemNm;
        return item1;
    }
    
    /*
    * 오류
    * */
//    public Item1(String itemId) {
//        this.itemId = itemId;
//    }
//    public Item1(String itemNm) {
//        this.itemNm = itemNm;
//    }
    /*
    * 장점 2 : 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.
    * 불변이고 자주 사용되는 객체라면 인스턴스를 매번 생성하지 않고 반환할 수 있다.
    * */
    public static Item1 getGucci() {
        return GUCCI;
    }

    /*
    * 장점 3 : 반환 타입의 하위 타입 객체를 반활할 수 있는 능력이 있다.
    *
    * */
    public static Item1 getGucciItem() {
        return new GucciItem();
    }
    public static Item1 getChanelItem() {
        return new ChanelItem();
    }

    /*
    * 장점 4 : 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    * */
    public static Item1 searchItem(String itemId) {
        if ("10001".equals(itemId))
            return new GucciItem();
        else
            return new ChanelItem();
    }

    /*
    * 장점 5 : 정적 팩터리 메서드를 작성하는 시점에는 반활할 객체의 클래스가 존재하지 않아도 된다.
    * */


    /*
    * 단점 1 : 상속 하려면 public이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
    * -> 생성자가 없거나 접근제어자가 private인 경우만 존재하면 상속을 받아 구현 할 수 없다.
    * */

    /*
    * 단점 2 : 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.
    *
    * */

    public static void main(String[] args) {
        Item1 item1 = new Item1("10000", "상품명");

        Item1 item = Item1.initItem("10000", "상품명");
    }

    @NoArgsConstructor
    public static class GucciItem extends Item1{

    }
    @NoArgsConstructor
    public static class ChanelItem extends Item1{

    }
}
