package sample3.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import sample3.dice.Dice;
import sample3.dice.Game;
import sample3.dice.Player;

@PropertySource({"classpath:game.properties"})
public class GameConfig {

    @Bean
    public Player kang(Dice dice) {
        Player player = new Player();
        player.setDice(dice); // dice를 주입하고 있는 코드 .. (설정자 방식으로 주입!!)
        player.setName("강경미");
        return player;
    }

    @Bean
    public Player hong(Dice dice) {
        Player player = new Player();
        player.setDice(dice); // dice를 주입하고 있는 코드 .. (설정자 방식으로 주입!!)
        player.setName("홍길씨");
        return player;
    }

    @Bean
    public Player lee(Dice dice) {
        Player player = new Player();
        player.setDice(dice); // dice를 주입하고 있는 코드 .. (설정자 방식으로 주입!!)
        player.setName("이재용");
        return player;
    }

    @Bean
    public Game game(List<Player> players) {
//        return new Game(players); // 생성자 주입
        Game game = new Game(); // 설정자 주입
        game.setList(players);
        return game;
    }

    @Bean
    public Dice dice(@Value("${face}") int face) {
        return new Dice(face);
    }
}
