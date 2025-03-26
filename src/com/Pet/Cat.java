package com.Pet;

public class Cat extends Animal implements Pet {
    public Cat(int legs) {
        super(legs);
    }

    @Override
    public void walk() {
        System.out.println("Cat is walking");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void play() {
        System.out.println("Cat is playing");
    }
}
