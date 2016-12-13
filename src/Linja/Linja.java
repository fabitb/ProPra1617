package Linja;

public class Linja extends MiniJava {

    private static int[][] spielfeld = new int[8][6];

    /**
     * initialisiert das Spielfeld 
     * Ziellinie fuer Spieler 1 ist Zeile 7
     * Ziellinie fuer Spieler -1 ist Zeile 0
     */
    private static void initSpiel() {
        for (int i = 0; i < spielfeld.length; i++) {
            if (i != 0 && i != spielfeld.length - 1) {
                spielfeld[i] = new int[]{-(12 - i + 1), 0, 0, 0, 0, 6 + i};
            }
            if (i == 0) {
                spielfeld[i] = new int[]{1, 2, 3, 4, 5, 6};
            }
            if (i == spielfeld.length - 1) {
                spielfeld[i] = new int[]{-6, -5, -4, -3, -2, -1};
            }
        }
    }

    /**
     *
     * @return formatiertes aktuelles Spielfeld
     */
    private static String output() {
        String tmp = "Spieler 1 spielt von oben nach unten\n"
                + "Spieler -1 spielt von unten nach oben\n";
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                tmp = tmp + "\t" + spielfeld[i][j];
            }
            tmp = tmp + "\n";
        }
        return tmp;
    }

    /**
     * @return true, wenn die Eingabe stein im richtigen Wertebereich liegt und
     * zum Spieler gehoert; false, sonst
     */
    private static boolean gueltigeEingabe(int stein, int spieler) {
        if ((stein >= -12 && stein <= -1) || (stein >= 1 && stein <= 12)){
            if ((stein < 0 && spieler < 0) || (stein > 0 && spieler > 0)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param stein kann Werte -1 bis -12 und 1 bis 12 haben
     * @return gibt x-Koordinate von stein an Position 0 und die y-Koordinaten
     * von stein an Position 1 zurueck; falls stein nicht gefunden, wird {-1,-1}
     * zurueckgegeben
     */
    private static int[] findeStein(int stein) {
        for (int i = 0; i < spielfeld.length; i++){
            for (int j = 0; j < spielfeld[i].length; j++){
                if (spielfeld[i][j] == stein){
                    int[] output = {i,j};
                    return output;
                }
            }
        }
        int[] output = {-1,-1};
        return output;
    }

    /**
     * @param reihe hat Werte 0 bis 7
     * @return Anzahl der Steine in einer Reihe
     */
    private static int steineInReihe(int reihe) {
        if (reihe >= 0 && reihe <= 7) {
            int x = 0;
            for (int i = 0; i < spielfeld[reihe].length; i++) {
                if (spielfeld[reihe][i] != 0) {
                    x++;
                }
            }
            return x;
        }
        System.err.println("Parameter \"reihe\" besitzt falschen Wert in Methode \"steineInReihe\"");
        return 0;
    }

    /**
     * Ueberprueft, ob der Zug zulaessig ist und fuehrt diesen aus, wenn er
     * zulaessig ist.
     *
     * @param vorwaerts == true: Zug erfolgt vorwaerts aus Sicht des
     * Spielers/Steins vorwearts == false: Zug erfolgt rueckwaerts aus Sicht des
     * Spielers/Steins
     * @return Rueckgabe -1: Zug nicht zulaessig Rueckgabe 0-5: Weite des
     * potentiellen naechsten Zugs (falls Folgezug folgt) Rueckgabe 6: Ziellinie
     * wurde genau getroffen (potentieller Bonuszug)
     *
     */
    private static int setzeZug(int stein, int weite, boolean vorwaerts) {
        if (vorwaerts){

        }
        else{
            if (stein > 0){
            }
        }
        return 0;
    }

    /**
     * @return true, falls die Bedingungen des Spielendes erfuellt sind, d.h. 
     * alle Steine des einen Spielers sind an den Steinen des gegnerischen Spielers
     * vorbeigezogen
     *
     */
    private static boolean spielende() {
        int hintersteReiheMitSteinSpieler1 = 7;
        int hintersteReiheMitSteinSpieler2 = 0;

        for (int i = 1; i <= 12; i++){
            if (findeStein(i)[0] < hintersteReiheMitSteinSpieler1){
                hintersteReiheMitSteinSpieler1 = findeStein(i)[0];
            }
        }
        for (int i = -1; i >= -12; i--){
            if (findeStein(i)[0] > hintersteReiheMitSteinSpieler2){
                hintersteReiheMitSteinSpieler2 = findeStein(i)[0];
            }
        }

        if (hintersteReiheMitSteinSpieler1 > hintersteReiheMitSteinSpieler2){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * zaehlt die Punkte der beiden Spieler und gibt das Ergebnis aus
     */
    private static void zaehlePunkte() {
        int pointsPlayer1 = 0;
        int pointsPlayer2 = 0;

        for (int i = 1; i <= 12; i++){
            int[] position = findeStein(i);

        }
    //TODO

    }

    /**
     * Spielablauf entsprechend Anfangszug, Folgezug, Bonuszug
     *
     * @param spieler ist 1 (Spielsteine 1 bis 12) oder -1 (Spielsteine -1 bis
     * -12)
     */
    private static void spielerZieht(int spieler) {
    
    //TODO

    }

    public static void main(String args[]) {

        initSpiel();
        System.out.println(output());
        //System.out.println(spielfeld.length);
        steineInReihe(8);
        
        //TODO

    }
}
