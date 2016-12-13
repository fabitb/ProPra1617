package SuV;

public class SuV extends MiniJava {


    private int sumOfCards1, sumOfCards2;
    private int playerOnTurn;

    public SuV(){
        sumOfCards1 = 0;
        sumOfCards2 = 0;
        playerOnTurn = 1;
    }

    public void startGame(){

        write("Spieler " + playerOnTurn + " ist am Zug!");
        int draw1 = drawCard();
        int draw2 = drawCard();
        if (playerOnTurn == 1){
            sumOfCards1 += draw1 + draw2;
        }
        else{
            sumOfCards2 += draw1 + draw2;
        }
        write("Du hast eine " + draw1 + " und eine " + draw2 + " gezogen.\nDeine Summe beträgt " + getSumOfPlayerOnTurn());
        if (getSumOfPlayerOnTurn() > 21){
            endGame();
            return;
        }
        while (getSumOfPlayerOnTurn() <= 21){
            int input = -1;
            do{
                input = readInt("Willst du noch eine Karte ziehen? 0 für nein; 1 für ja");
                if (input < 0 || input > 1){
                    write("Fehlerhafte Eingabe! Bitte nur 0 (keine Karte ziehen) oder 1 (eine Karte ziehen) eingeben");
                }
            }
            while (input > 1 || input < 0);
            if (input == 1){
                int drawNew = drawCard();
                if (playerOnTurn == 1){
                    sumOfCards1 += drawNew;
                }
                else{
                    sumOfCards2 += drawNew;
                }
                write("Du hast eine " + drawNew + " gezogen. Somit beträgt deine Summe nun " + getSumOfPlayerOnTurn());
                if (getSumOfPlayerOnTurn() > 21) {
                    endGame();
                    return;
                }
            }
            else{
                if (playerOnTurn == 1) {
                    playerOnTurn = 2;
                    startGame();
                    return;
                }
                else{
                    endGame();
                    return;
                }
            }
        }
    }

    private void endGame(){
        if (sumOfCards1 > 21){
            write("Spieler 2 hat gewonnen");
        }
        else if (sumOfCards2 > 21){
            write("Spieler 1 hat gewonnen");
        }
        else if (sumOfCards1 == sumOfCards2){
            write("Spieler 1 hat gewonnen");
        }
        else{
            if (sumOfCards1 > sumOfCards2){
                write("Spieler 1 hat gewonnen");
            }
            else{
                write("Spieler 2 hat gewonnen");
            }
        }
    }

    private int getSumOfPlayerOnTurn(){
        if (playerOnTurn == 1){
            return sumOfCards1;
        }
        else{
            return sumOfCards2;
        }
    }
}