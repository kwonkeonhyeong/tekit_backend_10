package sample3.dice;

import java.util.List;


public class Game {
    private List<Player> list;

    public Game() {
        System.out.println("Game() 생성자 실행!!");
    }

    public Game(List<Player> list) {
        System.out.println("GameList 생성자 실행!");
        this.list = list;
    }

    public void play() {
        for (Player player : list) {
            player.play();
        }
    }

    public void setList(List<Player> list) {
        this.list = list;
    }
}
