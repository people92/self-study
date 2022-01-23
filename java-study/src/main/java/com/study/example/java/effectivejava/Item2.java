package com.study.example.java.effectivejava;

import java.math.BigDecimal;

/*
* Item 2 : 생성자에 매개변수가 많다면 빌더를 고려하라
* */
public class Item2 {
    private String itemId;
    private String itemNm;
    private String uitemId;
    private String uitemNm;
    private BigDecimal price;

    public static class Builder {
        private String itemId;
        private String itemNm;

        private String uitemId = "00000"; //기본값으로 초기화
        private String uitemNm = "없음";

        private BigDecimal price;

        //필수값 매개변수
        public Builder(String itemId, String itemNm) {
            this.itemId = itemId;
            this.itemNm = itemNm;
        }

        public Builder uitemId(String val) {
            this.uitemId = val;
            return this;
        }
        public Builder uitemNm(String val) {
            this.uitemNm = val;
            return this;
        }
        public Builder price(BigDecimal val) {
            this.price = val;
            return this;
        }
        public Item2 build() {
            return new Item2(this);
        }
    }

    public Item2(Builder builder) {
        this.itemId = builder.itemId;
        this.itemNm = builder.itemNm;
        this.uitemId = builder.uitemId;
        this.uitemNm = builder.uitemNm;
        this.price = builder.price;
    }

    public static void main(String[] args) {
        Item2 item2 = new Builder("10001","상품명")
                .price(new BigDecimal("13300")).build();
    }
}
