package ch02;

public class Dog {
    String breed;
    int age;
    String color;
    // 생성자
    // 접근제한자 클래스명(매개변수들-초기화할 변수들...){}
    Dog(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }
    Dog(String breed,int age ,String color) {
        this.breed = breed;
        this.color = color;
        this.age = age;
    }

    Dog() {}

    // 메소드
    // 접근제한자 리턴타입 메소드명 (매개변수들...)
    void bark() {
        System.out.println("Woof!");
    }

    void displayInfo() {
        System.out.println("Breed: " + breed + " Age: " + age + " Color: " + color);
    }
}
