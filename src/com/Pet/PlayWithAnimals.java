package com.Pet;

public class PlayWithAnimals {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Spider(8);
        animals[1] = new Cat(4);
        animals[2] = new Fish(0);

        for (Animal animal : animals) {
            animal.walk();
            animal.eat();
            if (animal instanceof Pet) {
                Pet pet = (Pet) animal;
                pet.play();
            } else {
                System.out.println(animal.getClass() + " don't know how to play");
            }
        }
    }
}
