package RockPaperScissors;

import java.util.Random;

public class Player implements Runnable{

    // choice speichert, ob der Spieler Schere, Stein oder Papier hat
    int choice = -1;
    Random random = new Random();

    // public Methode, damit der Mainthread die Variable choice auslesen kann.
    public int getChoice() throws InterruptedException{
        return choice;
    }


    @Override
    public void run() {
        choice = random.nextInt(3);
    }
}
