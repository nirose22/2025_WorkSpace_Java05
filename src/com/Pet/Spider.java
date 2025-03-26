package com.Pet;

public class Spider extends Animal {
    public Spider(int legs) {
        super(legs);
    }

    @Override
    public void walk() {
        System.out.println("Spider is walking");
    }

    @Override
    public void eat() {
        System.out.println("Spider is eating");
    }
}
