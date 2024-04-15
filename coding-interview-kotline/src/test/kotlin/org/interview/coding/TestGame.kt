package org.interview.coding

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = org. junit. runners. Parameterized::class)
public class TestGame {
    private var game = Game()

    private var move1 : Move
    private var move2 : Move
    private var result : Result

    constructor( result: Result, move1: Move,move2: Move) {
        this.move2 = move2
        this.result = result
        this.move1 = move1
    }

    companion object {
        @JvmStatic
        @Parameters
        public fun testCondition() : List<*> {
            val outPut = arrayOf(
                arrayOf(Result.DRAW, Move.ROCK, Move.ROCK),
                arrayOf(Result.DRAW, Move.SCISSORS, Move.SCISSORS),
                arrayOf(Result.DRAW, Move.PAPER, Move.PAPER),
                arrayOf(Result.DRAW, Move.LIZARD, Move.LIZARD),
                arrayOf(Result.DRAW, Move.SPOCK, Move.SPOCK),

                arrayOf(Result.LOSE, Move.SCISSORS, Move.ROCK),
                arrayOf(Result.LOSE, Move.LIZARD, Move.ROCK),
                arrayOf(Result.LOSE, Move.PAPER, Move.SCISSORS),
                arrayOf(Result.LOSE, Move.LIZARD, Move.SCISSORS),
                arrayOf(Result.LOSE, Move.ROCK, Move.PAPER),
                arrayOf(Result.LOSE, Move.SPOCK, Move.PAPER),
                arrayOf(Result.LOSE, Move.SCISSORS, Move.SPOCK),
                arrayOf(Result.LOSE, Move.ROCK, Move.SPOCK),
                arrayOf(Result.LOSE, Move.PAPER, Move.LIZARD),
                arrayOf(Result.LOSE, Move.SPOCK, Move.LIZARD),

                arrayOf(Result.WIN, Move.PAPER, Move.ROCK),
                arrayOf(Result.WIN, Move.SPOCK, Move.ROCK),
                arrayOf(Result.WIN, Move.ROCK, Move.SCISSORS),
                arrayOf(Result.WIN, Move.SPOCK, Move.SCISSORS),
                arrayOf(Result.WIN, Move.SCISSORS, Move.PAPER),
                arrayOf(Result.WIN, Move.LIZARD, Move.PAPER),
                arrayOf(Result.WIN, Move.PAPER, Move.SPOCK),
                arrayOf(Result.WIN, Move.LIZARD, Move.SPOCK),
                arrayOf(Result.WIN, Move.SCISSORS, Move.LIZARD),
                arrayOf(Result.WIN, Move.ROCK, Move.LIZARD),

            )
            return listOf(*outPut)
        }
    }


    @Test
    fun testGame(){
        game.playGame(100)
        assertEquals(100,game.getTotalGames())
    }

    @Test
    fun testGetRoundResultWithRockMove() {
        assertEquals(Result.DRAW, game.getRoundResult(Move.ROCK, Move.ROCK))
    }

    @Test
    fun testGetRoundResultWithPaperMove() {
        assertEquals(Result.WIN, game.getRoundResult(Move.PAPER, Move.ROCK))
    }

    @Test
    fun testGetRoundResultWithScissorsMove() {
        assertEquals(Result.LOSE, game.getRoundResult(Move.SCISSORS, Move.ROCK))
    }

    @Test
    fun test() {

        assertEquals(Result.LOSE, game.getRoundResult(Move.SCISSORS, Move.ROCK))
        assertEquals(Result.WIN, game.getRoundResult(Move.PAPER, Move.ROCK))
        assertEquals(Result.DRAW, game.getRoundResult(Move.ROCK, Move.ROCK))
        assertEquals(Result.LOSE, game.getRoundResult(Move.LIZARD, Move.ROCK))
        assertEquals(Result.WIN, game.getRoundResult(Move.SPOCK, Move.ROCK))

        assertEquals(Result.DRAW, game.getRoundResult(Move.SCISSORS, Move.SCISSORS))
        assertEquals(Result.LOSE, game.getRoundResult(Move.PAPER, Move.SCISSORS))
        assertEquals(Result.WIN, game.getRoundResult(Move.ROCK, Move.SCISSORS))
        assertEquals(Result.LOSE, game.getRoundResult(Move.LIZARD, Move.SCISSORS))
        assertEquals(Result.WIN, game.getRoundResult(Move.SPOCK, Move.SCISSORS))

        assertEquals(Result.WIN, game.getRoundResult(Move.SCISSORS, Move.PAPER))
        assertEquals(Result.DRAW, game.getRoundResult(Move.PAPER, Move.PAPER))
        assertEquals(Result.LOSE, game.getRoundResult(Move.ROCK, Move.PAPER))
        assertEquals(Result.WIN, game.getRoundResult(Move.LIZARD, Move.PAPER))
        assertEquals(Result.LOSE, game.getRoundResult(Move.SPOCK, Move.PAPER))

        assertEquals(Result.LOSE, game.getRoundResult(Move.SCISSORS, Move.SPOCK))
        assertEquals(Result.WIN, game.getRoundResult(Move.PAPER, Move.SPOCK))
        assertEquals(Result.LOSE, game.getRoundResult(Move.ROCK, Move.SPOCK))
        assertEquals(Result.WIN, game.getRoundResult(Move.LIZARD, Move.SPOCK))
        assertEquals(Result.DRAW, game.getRoundResult(Move.SPOCK, Move.SPOCK))

        assertEquals(Result.WIN, game.getRoundResult(Move.SCISSORS, Move.LIZARD))
        assertEquals(Result.LOSE, game.getRoundResult(Move.PAPER, Move.LIZARD))
        assertEquals(Result.WIN, game.getRoundResult(Move.ROCK, Move.LIZARD))
        assertEquals(Result.DRAW, game.getRoundResult(Move.LIZARD, Move.LIZARD))
        assertEquals(Result.LOSE, game.getRoundResult(Move.SPOCK, Move.LIZARD))

    }
    @Test
    fun parameterizedTest() {
        assertEquals(result, game.getRoundResult(move1, move2))
    }

}