package RockPaperScissors;

public class RockPaperScissors implements Runnable {

    // zwei int-Variablen, um zu speichern wie oft welcher Spieler gewonnen hat
    int winsPlayerOne = 0;
    int winsPlayerTwo = 0;



    @Override
    public void run() {

        // Zwei Spieler erstellen
        Player player1 = new Player();
        Player player2 = new Player();

        // Zwei Threadobjekte erstellen und die gerade eben erzeugten Player mit übergeben.
        // Dies ist nur möglich, da die Klasse Player das Interface "Runnable" implementiert
        Thread threadPlayer1 = new Thread(player1);
        Thread threadPlayer2 = new Thread(player2);

        // 1000-mal Spielen
        for (int i = 0; i < 1000; i++){

            //Threads starten
            threadPlayer1.run();
            threadPlayer2.run();

            // Variablen, um die Ergebnisse zu speichern
            int one = -1;
            int two = -1;

            // So lange Schere, Stein, Papier spielen bis die ergebnisse unterschiedlich sind
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
                threadPlayer1.interrupt();
                threadPlayer2.interrupt();
            }
            while (one == two);

            // Check wer gewonnen hat
            if ((one == 1 && two == 0) || (one == 2 && two == 1) || (one == 0 && two == 2)){
                winsPlayerOne++;
                System.out.println("Spieler 1 hat gewonnen!");
            }
            else{
                winsPlayerTwo++;
                System.out.println("Spieler 2 hat gewonnen!");
            }
        }

        // Ausgabe wer wie viele Spiele gewonnen hat.
        System.out.println("Wins Player 1: " + winsPlayerOne);
        System.out.println("Wins Player 2: " + winsPlayerTwo);
    }


    //main-Methode, um den MainThread zu starten
    public static void main(String[] args) {
        Thread mainThread = new Thread(new RockPaperScissors());
        mainThread.run();
    }
}
