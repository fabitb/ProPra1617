package RockPaperScissors;

import java.util.Random;

public class Player implements Runnable{

    int choice;

    public Player(){

        choice = -1;

    }







    public int getChoice() throws InterruptedException{

        return choice;
    }


    @Override
    public void run() {

        Random random = new Random();
        choice = random.nextInt(3);

    }
}
