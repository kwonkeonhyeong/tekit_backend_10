package ch02;

public class Backpack {
    String brand;
    int price;
    String[] pocket;

    void put(String[] pocket) {
        System.out.println("가방에 물건들을 넣었습니다.");
    }

    String[] out() {
        System.out.println("가방에서 물건들을 꺼냈습니다.");
        return pocket;
    }
}
