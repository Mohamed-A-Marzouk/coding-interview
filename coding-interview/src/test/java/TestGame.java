import org.example.Game;
import org.example.Move;
import org.example.Result;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGame {

    Game game = new Game();

    @Test
    public void testGame(){
        game.playGame(100);
        assertEquals(100,game.getTotalGames());
    }
    @Test
    public void testGetRoundResultWithRockMove(){
        assertEquals(Result.DRAW,game.getRoundResult(Move.ROCK,Move.ROCK));
    }
    @Test
    public void testGetRoundResultWithPaperMove(){
        assertEquals(Result.WIN,game.getRoundResult(Move.PAPER,Move.ROCK));
    }
    @Test
    public void testGetRoundResultWithScissorsMove(){
        assertEquals(Result.LOSE,game.getRoundResult(Move.SCISSORS,Move.ROCK));
    }
}
