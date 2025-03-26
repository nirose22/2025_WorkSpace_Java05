package com.Pet;

public class Fish extends Animal implements Pet {
    public Fish(int legs) {
        super(legs);
    }

    @Override
    public void walk() {
        System.out.println("Fish can't walk");
    }

    @Override
    public void eat() {
        System.out.println("Fish can eat");
    }

    @Override
    public void play() {
        System.out.println("Fish can play");
    }
}
