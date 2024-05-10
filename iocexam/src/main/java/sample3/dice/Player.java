package sample3.dice;


public class Player {
    private String name;
    private Dice dice; // 실행될때 주사위를 주입받아야 한다.

    //DI 할 수 있는 방법은 ?? 필드 주입, 생성자 주입, 설정자(setter) 주입
    public Player() {
        System.out.println("player() 생성자 실행!");
    }


    public Player(String name, Dice dice) {
        this.name = name;
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void play() {
        System.out.println(name+"은 주사위를 던져서 "+dice.getNumber()+"가 나왔습니다.");
    }
}
