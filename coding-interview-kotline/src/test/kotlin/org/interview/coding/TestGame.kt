package org.interview.coding

import org.junit.Assert.assertEquals
import org.junit.Test


class TestGame {
    private var game = Game()
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
}