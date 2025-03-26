package com.Pet;

public abstract class Animal {
    protected int legs;

    protected Animal(int legs) {
        this.legs = legs;
    }

    public abstract void walk();
    public abstract void eat();
}
