package org.interview.coding

class Game {
    private var playerAWins = 0
    private var playerBWins = 0
    private var draws = 0

    private fun getRandomMove(): Move {
        return Move.entries.toTypedArray().random()
    }

    private fun playRound(){
        val player_A_Move = getRandomMove()
        val player_B_Move = Move.ROCK

        val result = getRoundResult(player_A_Move, player_B_Move)
        when (result) {
            Result.WIN -> playerAWins++
            Result.LOSE -> playerBWins++
            Result.DRAW -> draws++
        }
    }
    fun getRoundResult(playerAMove: Move, playerBMove: Move): Result {

      return when{
            playerAMove == playerBMove -> Result.DRAW

            playerAMove == Move.ROCK && playerBMove == Move.SCISSORS ||
                    (playerAMove == Move.ROCK && playerBMove == Move.LIZARD) ||
                    (playerAMove == Move.PAPER && playerBMove == Move.ROCK)||
                    (playerAMove == Move.PAPER && playerBMove == Move.SPOCK)||
                    (playerAMove == Move.SCISSORS && playerBMove == Move.PAPER)||
                    (playerAMove == Move.SCISSORS && playerBMove == Move.LIZARD)||
                    (playerAMove == Move.LIZARD && playerBMove == Move.PAPER)||
                    (playerAMove == Move.LIZARD && playerBMove == Move.SPOCK) ||
                    (playerAMove == Move.SPOCK && playerBMove == Move.SCISSORS)||
                    (playerAMove == Move.SPOCK && playerBMove == Move.ROCK)
            -> Result.WIN
            else -> Result.LOSE
        }
    }

    private fun printResults() {
        println(("Player A wins " + playerAWins + " of " + getTotalGames()).toString() + " games")
        println(("Player B wins " + playerBWins + " of " + getTotalGames()).toString() + " games")
        println(("Draws: " + draws + " of " + getTotalGames()).toString() + " games")
    }

    fun getTotalGames(): Int {
        return playerAWins + playerBWins + draws
    }

    fun playGame(rounds: Int) {
        for (i in 0 until rounds) {
            playRound()
        }
        printResults()
    }
}
