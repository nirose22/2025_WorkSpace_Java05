package com.example2;


public interface RegularStaff {
    String[] gift = {"pen", "pencil", "notebook", "eraser", "book"};
    static String getLuckyGift() {
        int index = (int) (Math.random() * gift.length);
        return gift[index];
    }

    default double calPerMultiplier() {
        return (int) (Math.random() * 5 + 1) * 0.5;
    }

    double getBonus();
}
