import org.example.Game;
import org.example.Move;
import org.example.Result;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class TestGame {

    Game game = new Game();
    private Move move1;
    private Move move2;
    private Result result;

    public TestGame(Result result, Move move1, Move move2) {
        this.move1 = move1;
        this.move2 = move2;
        this.result = result;
    }

    @Parameterized.Parameters
    public static List<Object[]> testCondition(){
        Object[][] outPut ={
            {Result.DRAW,Move.ROCK,Move.ROCK},
                {Result.WIN,Move.PAPER,Move.ROCK},
                {Result.LOSE,Move.SCISSORS,Move.ROCK},
                {Result.LOSE,Move.SCISSORS,Move.SCISSORS}

        };
        return Arrays.asList(outPut);
    }
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

    @Test
    public void test1() {
        assertEquals(result, game.getRoundResult(move1,move2));
    }
}
