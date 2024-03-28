import org.example.Game;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGame {


    @Test
    public void testGame(){
        Game game = new Game();
        game.playGame(100);
        assertEquals(100,game.getTotalGames());
    }
}
