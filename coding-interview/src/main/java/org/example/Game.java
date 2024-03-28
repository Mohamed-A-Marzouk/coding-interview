package org.example;

import java.util.Random;

public class Game {
    private int playerAWins = 0;
    private int playerBWins = 0;
    private int draws = 0;

    private Random random = new Random();
    private Move getRandomMove() {
        int randomNumber = random.nextInt(3);
        Move randomMove = Move.values()[randomNumber];
        return randomMove;
    }
    private void playRound() {
        Move player_A_Move = getRandomMove();
        Move player_B_Move = Move.ROCK;

        Result result = getRoundResult(player_A_Move, player_B_Move);

        switch (result){
            case WIN:
                playerAWins++;
                break;
            case LOSE:
                playerBWins++;
                break;
            case DRAW:
                draws++;
        }
    }

    public Result getRoundResult(Move playerAMove, Move playerBMove){
        if(playerAMove.equals(Move.ROCK)){
            return Result.DRAW;
        } else if (playerAMove.equals(Move.PAPER)) {
            return Result.WIN;
        }else {
            return Result.LOSE;
        }
    }
    private void printResults(){
        System.out.println("Player A wins "+playerAWins +" of "+getTotalGames()+" games");
        System.out.println("Player B wins "+playerBWins+" of "+getTotalGames()+" games");
        System.out.println("Draws: "+draws+" of "+getTotalGames()+" games");
    }

    public int getTotalGames(){
        return playerAWins+playerBWins+draws;
    }

    public void playGame(int rounds){
        for (int i = 0; i < rounds; i++) {
            playRound();
        }
        printResults();
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            playRound();
//        }
//        printResults();
//
//
//    }
}
