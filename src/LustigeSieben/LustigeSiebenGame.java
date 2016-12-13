package LustigeSieben;

import java.util.Random;
import java.util.Scanner;

public class LustigeSiebenGame {

    private int money = 100;
    private boolean endGame = false;

    public LustigeSiebenGame(){
        game();
    }

    private void game(){
        Scanner input = new Scanner(System.in);

        while (!endGame){
            System.out.println("Auf welches Feld willst du setzen? (0 beendet das Spiel)");
            int gesetztesFeld = -1;
            while (gesetztesFeld < 0 || gesetztesFeld > 12 || gesetztesFeld == 1){
                gesetztesFeld = input.nextInt();
            }
            if (gesetztesFeld == 0){
                endGame = true;
            }
            else{
                System.out.println("Wie viel Geld möchtest du setzen?");
                int gesetztesGeld = 0;
                while (gesetztesGeld <= 0 || gesetztesGeld > money){
                    gesetztesGeld = input.nextInt();
                }

                int diceRoll = dice() + dice();
                System.out.println("Die Bank hat eine " + diceRoll + " gewürfelt!");

                money = money + calculateWin(diceRoll,gesetztesFeld,gesetztesGeld);

                System.out.println("Dein Guthaben beträgt " + money + " €");
            }
            if (money < 1){
                endGame = true;
                System.out.println("Du hast kein Geld mehr!");
            }
        }
    }

    private int calculateWin(int _diceRoll, int _gesetztesFeld, int _gesetztesGeld){
        if (_diceRoll == 7 && _gesetztesFeld == 7){
            return _gesetztesGeld * 3;
        }
        else if (_gesetztesFeld == _diceRoll){
            return _gesetztesGeld * 2;
        }
        else if ((_gesetztesFeld < 7 && _diceRoll < 7) || (_gesetztesFeld > 7 && _diceRoll > 7)){
            return _gesetztesGeld;
        }
        else{
            return (-1) * _gesetztesGeld;
        }
    }

    private int dice (){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}