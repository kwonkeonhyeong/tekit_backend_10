package com.example.day07.interfaceExam;


public class AnimalDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.speak();
        cat.speak();

        System.out.println(Animal.age);
        System.out.println(Dog.age);
    }
}
