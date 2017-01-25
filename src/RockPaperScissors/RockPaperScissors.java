package RockPaperScissors;

/**
 * Created by FabianTB on 25.01.17.
 */
public class RockPaperScissors implements Runnable {

    int winsOne = 0;
    int winsTwo = 0;



    @Override
    public void run() {

        Player player1 = new Player();
        Player player2 = new Player();

        Thread threadPlayer1 = new Thread(player1);
        Thread threadPlayer2 = new Thread(player2);

        player1.run();
        player2.run();

        for (int i = 0; i < 1000; i++){

            threadPlayer1.run();
            threadPlayer2.run();

            int one = -1;
            int two = -1;

            do {
                threadPlayer1.run();
                threadPlayer2.run();
                try {
                    one = player1.getChoice();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    two = player2.getChoice();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (one == two);

            if ((one == 1 && two == 0) || (one == 2 && two == 1) || (one == 0 && two == 2)){
                winsOne++;
                //System.out.println("Spieler 1 hat gewonnen!");
            }
            else{
                winsTwo++;
                //System.out.println("Spieler 2 hat gewonnen!");
            }
        }

        threadPlayer1.interrupt();
        threadPlayer2.interrupt();

        System.out.println("Wins Player 1: " + winsOne);
        System.out.println("Wins Player 2: " + winsTwo);

    }

    public static void main(String[] args) {
        Thread mainThread = new Thread(new RockPaperScissors());
        mainThread.run();
    }
}
