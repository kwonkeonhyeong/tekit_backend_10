package ch02;

public class DogTest {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.breed = "wowowoowow";
        myDog.age = 11233;
        myDog.color = "black";
        myDog.bark();
        myDog.displayInfo();

        Dog myDog2 = new Dog("푸들", "갈색");
        myDog2.age = 8;

        myDog2.displayInfo();

        Dog myDog3 = new Dog("진돗개", 9, "노랑색");
        myDog3.displayInfo();
    }
}
