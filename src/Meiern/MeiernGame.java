package Meiern;

import java.util.Random;

public class MeiernGame {

    private boolean playersTurn;
    private int rollPlayer, rollComputer;
    private boolean gameWon;

    public MeiernGame(){
        playersTurn = true;
        rollPlayer = -1;
        rollComputer = -1;
        gameWon = false;

        game();
    }

    public void game (){
        while (!gameWon){
            if (playersTurn) {
                System.out.println("Der Spieler ist an der Reihe!");
                rollPlayer = diceMeiern();

                System.out.println("Der Spieler hat eine " + rollPlayer + " gewürfelt");

                if (rollPlayer == 21){
                    gameWon = true;
                    System.out.println("Der Spieler hat gewonnen");
                }
                else{
                    if (xGreatery(rollPlayer, rollComputer)){
                        playersTurn = !playersTurn;
                    }
                    else{
                        gameWon = true;
                        System.out.println("Der Computer hat gewonnen!");
                    }
                }

            } else {
                System.out.println("Der Computer ist an der Reihe!");
                rollComputer = diceMeiern();

                System.out.println("Der Computer hat eine " + rollComputer + " gewürfelt");

                if (rollComputer == 21){
                    gameWon = true;
                    System.out.println("Der Computer hat gewonnen");
                }
                else{
                    if (xGreatery(rollComputer, rollPlayer)){
                        playersTurn = !playersTurn;
                    }
                    else{
                        gameWon = true;
                        System.out.println("Der Spieler hat gewonnen!");
                    }
                }
            }
        }
    }

    private boolean xGreatery (int x, int y){
        if (x == y){
            return false;
        }
        else if (((x % 11) == 0) && ((y % 11) == 0)){
            if (x > y){
                return true;
            }
            else{
                return false;
            }
        }
        else if ((x % 11) == 0){
            return true;
        }
        else if ((y % 11) == 0){
            return false;
        }
        else{
            if (x > y){
                return true;
            }
            else{
                return false;
            }
        }
    }

    private int diceMeiern() {
        int x = dice();
        int y = dice();
        if (x > y) {
            return x * 10 + y;
        }
        else{
            return y * 10 + x;
        }
    }

    private int dice(){
        Random random = new Random();
        return (random.nextInt(6)) + 1;
    }
}