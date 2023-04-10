import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testFirstPlayerWins() {
        Game game = new Game();
        Player pit = new Player(1,"Pit", 100);
        Player jack = new Player(2,"Jack", 96);

        game.register(pit);
        game.register(jack);
        int actual = game.round("Pit","Jack");
        int expected = 1;

        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testSecondPlayerWins() {
        Game game = new Game();
        Player pit = new Player(1,"Pit", 96);
        Player jack = new Player(2,"Jack", 100);

        game.register(pit);
        game.register(jack);
        int actual = game.round("Pit","Jack");
        int expected = 2;

        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testNoWinnerTheGameIsADraw() {
        Game game = new Game();
        Player pit = new Player(1,"Pit", 100);
        Player jack = new Player(2,"Jack", 100);

        game.register(pit);
        game.register(jack);
        int actual = game.round("Pit","Jack");
        int expected = 0;

        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testWhenThereIsNoFirstPlayer() {
        Game game = new Game();
        Player pit = new Player(1,"Pit", 95);
        Player jack = new Player(2,"Jack", 100);

        game.register(pit);
        game.register(jack);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Jon","Jack")
        );
    }
    @Test
    public void testWhenThereIsNoFSecondPlayer() {
        Game game = new Game();
        Player pit = new Player(1,"Pit", 95);
        Player jack = new Player(2,"Jack", 100);

        game.register(pit);
        game.register(jack);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Pit","Jon")
        );
    }
    @Test
    public void testWhenBothPlayersAreAbsent() {
        Game game = new Game();
        Player pit = new Player(1,"Pit", 95);
        Player jack = new Player(2,"Jack", 100);

        game.register(pit);
        game.register(jack);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Lui","Jon")
        );
    }

}